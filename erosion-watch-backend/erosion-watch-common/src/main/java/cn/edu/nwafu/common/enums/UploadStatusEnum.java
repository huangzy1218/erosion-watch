package cn.edu.nwafu.common.enums;

import cn.edu.nwafu.common.api.IErrorCode;

/**
 * @author Huang Z.Y.
 */
public enum UploadStatusEnum implements IErrorCode {
    MISSING_ARGUMENTS(-1, "缺少必要参数"),
    FILE_EXIST(0, "文件已存在且大小一致"),
    FILE_NOT_EXIST(1, "文件不存在"),
    CHUNK_EXIST(2, "分片已存在"),
    CHUNK_NOT_EXIST(3, "分片不存在"),
    CHUNK_UPLOAD_ERROR(4, "分片上传出错"),
    CHUNK_MERGE_FAIL(5, "分片合并失败"),
    UPLOADING(6, "文件正在上传中"),
    FILE_UPLOAD_ERROR(7, "文件上传出错"),
    UPLOAD_FAIL(8, "上传失败");

    private final int code;
    private final String description;

    UploadStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static UploadStatusEnum getByCode(long code) {
        for (UploadStatusEnum status : UploadStatusEnum.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid UploadStatus code: " + code);
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return description;
    }

    public String getDescription() {
        return description;
    }
}
