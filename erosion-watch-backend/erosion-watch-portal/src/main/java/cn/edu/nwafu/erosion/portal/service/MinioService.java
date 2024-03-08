package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.portal.domain.dto.MinioUploadDto;
import cn.edu.nwafu.erosion.portal.enums.Bucket;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用于上传和删除文件到Minio对象存储服务。
 *
 * @author Huang Z.Y.
 */
public interface MinioService {
    MinioUploadDto upload(MultipartFile file, Bucket type);

    boolean delete(String fileName);
}
