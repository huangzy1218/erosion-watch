package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.model.SoilErosionGrade;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilErosionGradeDto;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilErosionGradeSearchDto;
import cn.edu.nwafu.erosion.portal.service.SoilErosionGradeService;
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
@Api(tags = "SoilErosionGradeController")
@Tag(name = "SoilErosionGradeController", description = "土壤侵蚀程度管理")
@Controller
@RequestMapping("/soil-erosion-grade")
public class SoilErosionGradeController {
    @Autowired
    private SoilErosionGradeService soilErosionGradeService;

    @ApiOperation("添加土壤侵蚀等级")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<?> add(@RequestBody SoilErosionGradeDto soilErosionGradeDto) {
        int count = soilErosionGradeService.add(soilErosionGradeDto);
        if (count > 0) {
            return CommonResult.success(null, "添加土壤侵蚀等级成功");
        } else {
            return CommonResult.failed("添加土壤侵蚀等级失败");
        }
    }

    @ApiOperation("根据ID查询土壤侵蚀等级")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<SoilErosionGrade> getSoilErosionGradeById(@PathVariable Long id) {
        SoilErosionGrade soilErosionGrade = soilErosionGradeService.getById(id);
        return CommonResult.success(soilErosionGrade);
    }

    @ApiOperation("更新土壤侵蚀等级")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult<?> update(@PathVariable Long id, @RequestBody SoilErosionGradeDto soilErosionGradeDto) {
        int count = soilErosionGradeService.update(id, soilErosionGradeDto);
        if (count > 0) {
            return CommonResult.success("更新土壤侵蚀等级成功");
        } else {
            return CommonResult.failed("更新土壤侵蚀等级失败");
        }
    }

    @ApiOperation("删除土壤侵蚀等级")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public CommonResult<?> delete(@PathVariable Long id) {
        int count = soilErosionGradeService.delete(id);
        if (count > 0) {
            return CommonResult.success("删除土壤侵蚀等级成功");
        } else {
            return CommonResult.failed("删除土壤侵蚀等级失败");
        }
    }

    @ApiOperation("查询所有土壤侵蚀等级")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<List<SoilErosionGrade>> listAll() {
        List<SoilErosionGrade> soilErosionGradeList = soilErosionGradeService.listAll();
        return CommonResult.success(soilErosionGradeList);
    }

    @ApiOperation("根据条件查询土壤侵蚀等级")
    @PostMapping("/search")
    @ResponseBody
    public CommonResult<List<SoilErosionGrade>> search(@RequestBody SoilErosionGradeSearchDto soilErosionGradeSearchDto) {
        List<SoilErosionGrade> soilErosionGradeList = soilErosionGradeService.search(soilErosionGradeSearchDto);
        return CommonResult.success(soilErosionGradeList);
    }
}
    