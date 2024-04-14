package cn.edu.nwafu.erosion.portal.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
@Data
public class FileRecord {
    /**
     * 主键id
     */
    private long id;

    /**
     * 上传分片的链接
     */
    private String fileUrl;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * MD5
     */
    private String md5;

    /**
     * 上传id
     */
    private String uploadId;

    /**
     * 是否已上传
     */
    private int isUploaded;

    /**
     * 分片总块数
     */
    private int totalChunks;

    /**
     * 文件大小（K）
     */
    private long size;

    /**
     * 已完成片数
     */
    private int completedParts;

    /**
     * 生成时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 删除时间（软删除）
     */
    private Date deletedAt;
}
    