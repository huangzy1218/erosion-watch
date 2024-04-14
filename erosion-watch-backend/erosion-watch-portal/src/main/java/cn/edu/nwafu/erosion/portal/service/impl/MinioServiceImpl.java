package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.common.service.CustomMinioClient;
import cn.edu.nwafu.common.service.RedisService;
import cn.edu.nwafu.erosion.portal.domain.dto.BucketPolicyConfigDto;
import cn.edu.nwafu.erosion.portal.domain.dto.MinioUploadDto;
import cn.edu.nwafu.erosion.portal.enums.Bucket;
import cn.edu.nwafu.erosion.portal.service.MinioService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import io.minio.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class MinioServiceImpl implements MinioService {
    @Autowired
    private CustomMinioClient minioClient;
    @Autowired
    private RedisService redisService;
    @Value("${minio.bucket-name}")
    private String BUCKET_NAME;
    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.access-key}")
    private String ACCESS_KEY;
    @Value("${minio.secret-key}")
    private String SECRET_KEY;
    @Value("${minio.redis-key}")
    private String MINIO_KEY;

    @Override
    public MinioUploadDto upload(MultipartFile file, Bucket bucket) {
        try {
            boolean isExist = minioClient
                    .bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
            if (isExist) {
                log.info("存储桶已经存在");
            } else {
                // 创建存储桶并设置只读权限
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
                BucketPolicyConfigDto bucketPolicyConfigDto = createBucketPolicyConfigDto(BUCKET_NAME);
                SetBucketPolicyArgs setBucketPolicyArgs = SetBucketPolicyArgs.builder()
                        .bucket(BUCKET_NAME)
                        .config(JSONUtil.toJsonStr(bucketPolicyConfigDto))
                        .build();
                minioClient.setBucketPolicy(setBucketPolicyArgs);
            }
            String filename = file.getOriginalFilename();
            // 设置存储对象名称
            String prefix = "";
            switch (bucket) {
                case data -> prefix = "data";
                case avatar -> prefix = "avatar";
                case ref -> prefix = "ref";
                default -> {
                }
            }
            String objectName = prefix + "/" + filename;
            // 使用putObject上传一个文件到存储桶中
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(BUCKET_NAME)
                    .object(objectName)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), ObjectWriteArgs.MIN_MULTIPART_SIZE).build();
            minioClient.putObject(putObjectArgs);
            log.info("文件上传成功");
            MinioUploadDto minioUploadDto = new MinioUploadDto();
            minioUploadDto.setName(filename);
            minioUploadDto.setUrl(ENDPOINT + "/" + BUCKET_NAME + "/" + objectName);
            log.info("miniUploadDto: {}", minioUploadDto);
            return minioUploadDto;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("上传发生错误: {}", e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(String fileName) {
        try {
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(ENDPOINT)
                    .credentials(ACCESS_KEY, SECRET_KEY)
                    .build();
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(BUCKET_NAME)
                    .object(fileName).build());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 创建存储桶的访问策略，设置为只读权限
     */
    private BucketPolicyConfigDto createBucketPolicyConfigDto(String bucketName) {
        BucketPolicyConfigDto.Statement statement = BucketPolicyConfigDto.Statement.builder()
                .effect("Allow")
                .principal("*")
                .action("s3:GetObject")
                .resource("arn:aws:s3:::" + bucketName + "/*.**").build();
        return BucketPolicyConfigDto.builder()
                .version("2012-10-17")
                .statement(CollUtil.toList(statement))
                .build();
    }

    /**
     public Map<String, Object> createMultipartUpload(FileMultipartDto fileMultipartDto) throws
     Exception {
     log.info("fileMultipartDTO:{}", fileMultipartDto);
     String fileName = fileMultipartDto.getFileName();
     Integer chunkSize = fileMultipartDto.getChunkSize();
     String bucketName = fileMultipartDto.getBucketName();

     // 1. 根据文件名创建签名
     // 2. 获取uploadId
     String contentType = "application/octet-stream";
     HashMultimap<String, String> headers = HashMultimap.create();
     headers.put("Content-Type", contentType);
     CreateMultipartUploadResponse response = minioClient.uploadId(bucketName, null, fileName, null, null);
     String uploadId = response.result().uploadId();

     Map<String, Object> result = new HashMap<>(3, 1);
     String md5 = MD5Util.encryptToMd5(fileName + chunkSize + bucketName);
     // 查询是否已存在,若存在返回对应数据
     Map<String, Object> checkResult;
     // 检查redis中是否已存在
     //checkResult = checkIsExistInRedis(md5);
     if (checkResult != null && !checkResult.isEmpty()) {
     log.info("Redis中存在");
     return checkResult;
     }
     //检查数据库中是否已存在
     //checkResult = checkIsExistInDatabase(md5);
     if (checkResult != null && !checkResult.isEmpty()) {
     log.info("数据库中存在");
     //redis中补充
     checkResult.put("fileName", fileName);
     redisService.set(MINIO_KEY + md5, result, 1, TimeUnit.HOURS);

     return checkResult;
     }

     //redis中和数据库中都没有，需要生成
     result.put("uploadId", uploadId);
     // 3. 请求Minio 服务，获取每个分块带签名的上传URL
     Map<String, String> reqParams = new HashMap<>(3, 1);
     reqParams.put("uploadId", uploadId);
     List<String> uploadUrlList = new ArrayList<>();
     // 4. 循环分块数 从1开始
     for (int i = 1; i <= chunkSize; i++) {
     reqParams.put("partNumber", String.valueOf(i));
     // 获取URL
     String uploadUrl = minioClient.getPresignedObjectUrl(bucketName, fileName, reqParams);
     // 添加到集合
     result.put("chunk_" + (i - 1), uploadUrl);
     uploadUrlList.add(uploadUrl);
     }
     log.info(">>>>分片数据入redis和数据库");
     result.put("fileName", fileName);
     redisService.set(MINIO_KEY + md5, result, 8, TimeUnit.HOURS);
     // 入库
     String uploadUrls = JSON.toJSONString(uploadUrlList);
     FileRecord fileRecord = new FileRecord()
     .setFileName(fileName)
     .setFileUrl(uploadUrls)
     .setUploadId(uploadId)
     .setTotalChunks(chunkSize)
     .setMd5(md5)
     // 上传完成后，接收到合并请求时再改以下参数
     .setCompletedParts(0)
     .setSize(0)
     .setIsUploaded(0);
     //fileRecordMapper.insert(fileRecord);
     return result;
     }


     public Result completeMultipartUpload(FileCompleteDto fileObject) {
     String bucketName = fileObject.getBucketName();
     String uploadId = fileObject.getUploadId();
     String objectName = fileObject.getObjectName();
     int completedParts;
     int size = 0;
     try {
     Part[] parts = new Part[10000];
     ListPartsResponse partResult = minioClient.listParts(bucketName, null, objectName, 1000, 0, uploadId, null, null);
     List<Part> partList = partResult.result().partList();
     completedParts = partList.size();
     int partNumber = 1;
     log.info("总片数：================" + completedParts + "========");
     for (Part part : partList) {
     parts[partNumber - 1] = new Part(partNumber, part.etag());   //etag就是分片信息
     partNumber++;
     size += part.partSize();
     }
     minioClient.completeMultipartUpload(bucketName, null, objectName, uploadId, parts, null, null);
     } catch (Exception e) {
     e.printStackTrace();
     return Result.fail("合并失败：" + e.getMessage());
     }
     // 合并成功，入库
     // 通过uploadId修改对应的记录行
     fileRecordMapper.updateStatusByUploadId(uploadId, completedParts, size);
     return Result.success();
     }*/
}
    