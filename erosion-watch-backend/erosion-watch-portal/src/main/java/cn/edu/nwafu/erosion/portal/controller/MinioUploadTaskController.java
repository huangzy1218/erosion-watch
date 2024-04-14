package cn.edu.nwafu.erosion.portal.controller;


import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.portal.model.dto.TaskInfoDTO;
import cn.edu.nwafu.erosion.portal.model.entity.SysUploadTask;
import cn.edu.nwafu.erosion.portal.model.param.InitTaskParam;
import cn.edu.nwafu.erosion.portal.service.SysUploadTaskService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * 分片上传-分片任务记录表控制层
 *
 * @since 2022-08-22 17:47:31
 */
@RestController
@Api(tags = "MinioUploadTaskController")
@Tag(name = "MinioUploadTaskController", description = "Minio分片上传")
@RequestMapping("minio/tasks")
public class MinioUploadTaskController {
    /**
     * 服务对象
     */
    @Resource
    private SysUploadTaskService sysUploadTaskService;


    /**
     * 获取上传进度
     *
     * @param identifier 文件md5
     * @return
     */
    @GetMapping("/{identifier}")
    public CommonResult<TaskInfoDTO> taskInfo(@PathVariable("identifier") String identifier) {
        return CommonResult.success(sysUploadTaskService.getTaskInfo(identifier));
    }

    /**
     * 创建一个上传任务
     *
     * @return
     */
    @PostMapping
    public CommonResult<TaskInfoDTO> initTask(@Valid @RequestBody InitTaskParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return CommonResult.failed(bindingResult.getFieldError().getDefaultMessage());
        }
        return CommonResult.success(sysUploadTaskService.initTask(param));
    }

    /**
     * 获取每个分片的预签名上传地址
     *
     * @param identifier
     * @param partNumber
     * @return
     */
    @GetMapping("/{identifier}/{partNumber}")
    public CommonResult preSignUploadUrl(@PathVariable("identifier") String identifier,
                                         @PathVariable("partNumber") Integer partNumber) {
        SysUploadTask task = sysUploadTaskService.getByIdentifier(identifier);
        if (task == null) {
            return CommonResult.failed("分片任务不存在");
        }
        Map<String, String> params = new HashMap<>();
        params.put("partNumber", partNumber.toString());
        params.put("uploadId", task.getUploadId());
        return CommonResult.success(sysUploadTaskService.genPreSignUploadUrl(task.getBucketName(), task.getObjectKey(), params));
    }

    /**
     * 合并分片
     *
     * @param identifier
     * @return
     */
    @PostMapping("/merge/{identifier}")
    public CommonResult<?> merge(@PathVariable("identifier") String identifier) {
        sysUploadTaskService.merge(identifier);
        return CommonResult.success(null);
    }
}
