package cn.edu.nwafu.erosion.portal.domain.dto;

import lombok.Data;

/**
 * @author Huang Z.Y.
 */
@Data
public class FileMultipartDto {
    private String fileName;
    private Integer chunkSize;
    private String bucketName;
}
    