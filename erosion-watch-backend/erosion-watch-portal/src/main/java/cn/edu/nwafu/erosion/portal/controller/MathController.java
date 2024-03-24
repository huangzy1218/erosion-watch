package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.portal.domain.dto.CommonDataDto;
import cn.edu.nwafu.erosion.portal.domain.vo.CommonStatisticsVo;
import cn.edu.nwafu.erosion.portal.domain.vo.HypothesisTestResultVo;
import cn.edu.nwafu.erosion.portal.domain.vo.LinearRegressionVo;
import cn.edu.nwafu.erosion.portal.service.MathService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
@Controller
@Api(tags = "MathController")
@Tag(name = "MathController", description = "数学统计")
@RequestMapping("/math")
public class MathController {
    @Autowired
    private MathService mathService;

    @ApiOperation("描述性分析")
    @PostMapping("/descriptive-analysis")
    @ResponseBody
    public CommonResult<?> descriptiveAnalysis(@RequestBody CommonDataDto commonDataDto) {
        List<CommonStatisticsVo> vos = mathService.descriptiveAnalysis(commonDataDto);
        return CommonResult.success(vos, "描述性分析成功");
    }

    @ApiOperation("线性回归分析")
    @GetMapping("/linear-regression")
    @ResponseBody
    public CommonResult<LinearRegressionVo> performLinearRegression(@RequestParam double[] xValues,
                                                                    @RequestParam double[] yValues) {
        LinearRegressionVo vo = mathService.linearRegression(xValues, yValues);
        return CommonResult.success(vo, "线性回归分析成功");
    }

    @PostMapping("/hypothesis/t")
    public CommonResult<HypothesisTestResultVo> performTTest(@RequestParam double[] sample1,
                                                             @RequestParam double[] sample2) {
        HypothesisTestResultVo vo = mathService.performTTest(sample1, sample2);
        return CommonResult.success(vo, "线性回归分析成功");
    }

    @PostMapping("/hypothesis/chisquare")
    public CommonResult<HypothesisTestResultVo> performChiSquareTest(@RequestParam double[] sample1,
                                                                     @RequestParam double[] sample2) {
        HypothesisTestResultVo vo = mathService.performChiSquareTest(sample1, sample2);
        return CommonResult.success(vo, "线性回归分析成功");
    }

    @PostMapping("/hypothesis/f")
    public CommonResult<HypothesisTestResultVo> performFTest(@RequestParam double[] sample1,
                                                             @RequestParam double[] sample2) {
        HypothesisTestResultVo vo = mathService.performFTest(sample1, sample2);
        return CommonResult.success(vo, "线性回归分析成功");
    }
}
    