package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonPage;
import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.model.VegetationCoverage;
import cn.edu.nwafu.erosion.portal.domain.dto.VegetationCoverageDto;
import cn.edu.nwafu.erosion.portal.domain.dto.VegetationCoverageSearchDto;
import cn.edu.nwafu.erosion.portal.service.VegetationCoverageService;
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
@Api(tags = "VegetationCoverageController")
@Tag(name = "VegetationCoverageController", description = "植被覆盖管理")
@Controller
@RequestMapping("/vegetation-coverage")
public class VegetationCoverageController {
    @Autowired
    private VegetationCoverageService vegetationCoverageService;

    @ApiOperation("添加植被覆盖信息")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<?> add(@RequestBody VegetationCoverageDto vegetationCoverageDto) {
        int count = vegetationCoverageService.add(vegetationCoverageDto);
        if (count > 0) {
            return CommonResult.success(null, "添加植被覆盖信息成功");
        } else {
            return CommonResult.failed("添加植被覆盖信息失败");
        }
    }

    @ApiOperation("根据ID查询植被覆盖信息")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<VegetationCoverage> getVegetationCoverageById(@PathVariable Long id) {
        VegetationCoverage vegetationCoverage = vegetationCoverageService.getById(id);
        return CommonResult.success(vegetationCoverage);
    }

    @ApiOperation("更新植被覆盖信息")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult<?> update(@PathVariable Long id, @RequestBody VegetationCoverageDto vegetationCoverageDto) {
        int count = vegetationCoverageService.update(id, vegetationCoverageDto);
        if (count > 0) {
            return CommonResult.success("更新植被覆盖信息成功");
        } else {
            return CommonResult.failed("更新植被覆盖信息失败");
        }
    }

    @ApiOperation("删除植被覆盖信息")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public CommonResult<?> delete(@PathVariable Long id) {
        int count = vegetationCoverageService.delete(id);
        if (count > 0) {
            return CommonResult.success("删除植被覆盖信息成功");
        } else {
            return CommonResult.failed("删除植被覆盖信息失败");
        }
    }

    @ApiOperation("查询所有植被覆盖信息")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<VegetationCoverage>> listAll() {
        List<VegetationCoverage> vegetationCoverageList = vegetationCoverageService.listAll();
        return CommonResult.success(CommonPage.restPage(vegetationCoverageList));
    }

    @ApiOperation("根据条件查询植被覆盖信息")
    @PostMapping("/search")
    @ResponseBody
    public CommonResult<CommonPage<VegetationCoverage>> search(@RequestBody VegetationCoverageSearchDto vegetationCoverageSearchDto) {
        List<VegetationCoverage> vegetationCoverageList = vegetationCoverageService.search(vegetationCoverageSearchDto);
        return CommonResult.success(CommonPage.restPage(vegetationCoverageList));
    }
}
