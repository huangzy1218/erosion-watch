package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.portal.domain.dto.USLEInputDto;
import cn.edu.nwafu.erosion.portal.service.ErosionAnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Huang Z.Y.
 */
@Api(tags = "土壤侵蚀分析")
@Tag(name = "ErosionAnalysisController", description = "土壤侵蚀分析")
@Controller
@RequestMapping("/erosion-analysis")
public class ErosionAnalysisController {
    @Autowired
    private ErosionAnalysisService erosionAnalysisService;

    @ApiOperation("添加土地管理计划")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<?> analysisInput(@RequestBody USLEInputDto usleInputDto) {
        int count = erosionAnalysisService.analysis(usleInputDto);
        if (count > 0) {
            return CommonResult.success(null, "添加土地管理计划成功");
        } else {
            return CommonResult.failed("添加土地管理计划失败");
        }
    }
}
    