package cn.edu.nwafu.erosion.portal.domain.dto;

import lombok.Data;

/**
 * @author Huang Z.Y.
 */
@Data
public class FileCompleteDto {
    private String bucketName;
    private String uploadId;
    private String objectName;
}
    