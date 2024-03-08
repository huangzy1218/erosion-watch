package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.portal.domain.dto.BucketPolicyConfigDto;
import cn.edu.nwafu.erosion.portal.domain.dto.MinioUploadDto;
import cn.edu.nwafu.erosion.portal.service.MinioService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import io.minio.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class MinioServiceImpl implements MinioService {
    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucket-name}")
    private String BUCKET_NAME;
    @Value("${minio.access-key}")
    private String ACCESS_KEY;
    @Value("${minio.secret-key}")
    private String SECRET_KEY;

    @Override
    public MinioUploadDto upload(MultipartFile file) {
        try {
            // 创建一个MinIO的Java客户端
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(ENDPOINT)
                    .credentials(ACCESS_KEY, SECRET_KEY)
                    .build();
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            // 设置存储对象名称
            String objectName = sdf.format(new Date()) + "/" + filename;
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
}
    