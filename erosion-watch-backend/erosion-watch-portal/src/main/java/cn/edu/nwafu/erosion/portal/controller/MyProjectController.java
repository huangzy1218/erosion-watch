package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonPage;
import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.portal.domain.vo.AnalysisProjectVo;
import cn.edu.nwafu.erosion.portal.service.MyProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author Huang Z.Y.
 */
@Api(tags = "MyProjectController")
@Tag(name = "MyProjectController", description = "我的项目")
@RequestMapping("/my-project")
@Controller
public class MyProjectController {
    @Autowired
    private MyProjectService myProjectService;

    @ApiOperation("新增项目")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<Null> add(@RequestParam("fid") Long fid) {
        boolean success = myProjectService.add(fid);
        if (success) {
            return CommonResult.success("新增项目成功");
        }
        return CommonResult.success("新增项目失败");
    }

    @ApiOperation("列出项目")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<AnalysisProjectVo>> listAll() {
        List<AnalysisProjectVo> dataList = myProjectService.listAll();
        return CommonResult.success(CommonPage.restPage(dataList));
    }
}
    