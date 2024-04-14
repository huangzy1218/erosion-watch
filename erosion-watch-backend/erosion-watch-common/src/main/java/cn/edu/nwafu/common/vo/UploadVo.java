package cn.edu.nwafu.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文件上传 VO
 *
 * @author Huang Z.Y.
 */
@Data
@ApiModel("文件上传VO")
public class UploadVo {
    /**
     * 分片片数
     */
    @ApiModelProperty(value = "分片片数", required = true)
    private Long chunks;

    /**
     * 当前分片标识
     */
    @ApiModelProperty(value = "当前分片标识", required = true)
    private Long chunk;

    /**
     * 分片设置大小
     */
    @ApiModelProperty(value = "分片设置大小", required = true)
    private Long chunkSize;
}
    