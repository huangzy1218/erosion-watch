package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonPage;
import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.model.SoilType;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilTypeDto;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilTypeSearchDto;
import cn.edu.nwafu.erosion.portal.service.SoilTypeService;
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
@Api(tags = "SoilTypeController")
@Tag(name = "SoilTypeController", description = "土壤类型管理")
@RequestMapping("/soil-type")
public class SoilTypeController {
    @Autowired
    private SoilTypeService soilTypeService;

    @ApiOperation("添加土壤类型")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<?> add(@RequestBody SoilTypeDto soilTypeDto) {
        int count = soilTypeService.add(soilTypeDto);
        if (count > 0) {
            return CommonResult.success(null, "添加土壤类型成功");
        } else {
            return CommonResult.failed("添加土壤类型失败");
        }
    }

    @ApiOperation("根据ID查询土壤类型")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<SoilType> getSoilTypeById(@PathVariable Long id) {
        SoilType soilType = soilTypeService.getById(id);
        return CommonResult.success(soilType);
    }

    @ApiOperation("更新土壤类型")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult<?> update(@PathVariable Long id, @RequestBody SoilTypeDto soilTypeDto) {
        int count = soilTypeService.update(id, soilTypeDto);
        if (count > 0) {
            return CommonResult.success("更新土壤类型成功");
        } else {
            return CommonResult.failed("更新土壤类型失败");
        }
    }

    @ApiOperation("删除土壤类型")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public CommonResult<?> delete(@PathVariable Long id) {
        int count = soilTypeService.delete(id);
        if (count > 0) {
            return CommonResult.success("删除土壤类型成功");
        } else {
            return CommonResult.failed("删除土壤类型失败");
        }
    }

    @ApiOperation("查询所有土壤类型")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<SoilType>> listAll() {
        List<SoilType> soilTypeList = soilTypeService.listAll();
        return CommonResult.success(CommonPage.restPage(soilTypeList));
    }

    @ApiOperation("根据条件查询土壤类型")
    @PostMapping("/search")
    @ResponseBody
    public CommonResult<CommonPage<SoilType>> search(@RequestBody SoilTypeSearchDto soilTypeSearchDto) {
        List<SoilType> soilTypeList = soilTypeService.search(soilTypeSearchDto);
        return CommonResult.success(CommonPage.restPage(soilTypeList));
    }
}
