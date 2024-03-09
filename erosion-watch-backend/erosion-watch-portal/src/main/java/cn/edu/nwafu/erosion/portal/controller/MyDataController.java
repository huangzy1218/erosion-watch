package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonPage;
import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.portal.domain.vo.ExcelFileVo;
import cn.edu.nwafu.erosion.portal.service.MyDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author Huang Z.Y.
 */
@Api(tags = "MyDataController")
@Tag(name = "MyDataController", description = "我的数据")
@RequestMapping("/my-data")
@Controller
@Slf4j
public class MyDataController {
    @Autowired
    private MyDataService myDataService;

    @PostMapping("/upload")
    @ResponseBody
    public CommonResult<Null> upload(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return CommonResult.failed("上传文件为空");
        }
        boolean success = myDataService.upload(file);
        if (success) {
            return CommonResult.success("上传文件成功");
        }
        return CommonResult.success("上传文件失败");
    }

    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<ExcelFileVo>> listAll() {
        List<ExcelFileVo> dataList = myDataService.listAll();
        return CommonResult.success(CommonPage.restPage(dataList));
    }

    @ApiOperation("删除我的数据")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public CommonResult<?> delete(@PathVariable Long id) {
        int count = myDataService.delete(id);
        if (count > 0) {
            return CommonResult.success("删除我的数据成功");
        } else {
            return CommonResult.failed("删除我的数据失败");
        }
    }
}
    