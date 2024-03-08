package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.portal.domain.dto.MinioUploadDto;
import cn.edu.nwafu.erosion.portal.service.MinioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Huang Z.Y.
 */
@Api(tags = "MyDataController")
@Tag(name = "MyDataController", description = "我的数据")
@RequestMapping("/my-data")
@Controller
public class MyDataController {
    @Autowired
    private MinioService minioService;

    @PostMapping("/upload")
    @ApiImplicitParam(name = "file", value = "excel文件导入", required = true, dataType = "MultipartFile",
            allowMultiple = true, paramType = "query")
    public CommonResult<?> upload(@RequestPart @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return CommonResult.failed("上传文件为空");
        }

        try {
            MinioUploadDto uploadDto = minioService.upload(file);
            if (uploadDto != null) {
                return CommonResult.success(uploadDto, "上传文件成功");
            } else {
                return CommonResult.failed("上传文件失败");
            }
        } catch (Exception e) {
            return CommonResult.failed("文件上传发生异常：" + e.getMessage());
        }
    }
}
    