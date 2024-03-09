package cn.edu.nwafu.erosion.portal.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件上传返回结果
 *
 * @author Huang Z.Y.
 */
@Data
@EqualsAndHashCode
public class MinioUploadDto {
    @ApiModelProperty("文件访问URL")
    private String url;
    @ApiModelProperty("文件名称")
    private String name;

    @Override
    public String toString() {
        return "MinioUploadDto{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
    