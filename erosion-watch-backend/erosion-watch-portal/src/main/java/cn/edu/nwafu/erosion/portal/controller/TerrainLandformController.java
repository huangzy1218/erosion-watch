package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.model.TerrainLandform;
import cn.edu.nwafu.erosion.portal.domain.dto.TerrainLandformDto;
import cn.edu.nwafu.erosion.portal.domain.dto.TerrainLandformSearchDto;
import cn.edu.nwafu.erosion.portal.service.TerrainLandformService;
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
@Api(tags = "TerrainLandformController")
@Tag(name = "TerrainLandformController", description = "地形地貌管理")
@Controller
@RequestMapping("/terrain-landforms")
public class TerrainLandformController {
    @Autowired
    private TerrainLandformService terrainLandformService;

    @ApiOperation("添加地形地貌信息")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<?> add(@RequestBody TerrainLandformDto terrainLandformDto) {
        int count = terrainLandformService.add(terrainLandformDto);
        if (count > 0) {
            return CommonResult.success(null, "添加地形地貌信息成功");
        } else {
            return CommonResult.failed("添加地形地貌信息失败");
        }
    }

    @ApiOperation("根据ID查询地形地貌信息")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<TerrainLandform> getTerrainLandformById(@PathVariable Long id) {
        TerrainLandform terrainLandform = terrainLandformService.getById(id);
        return CommonResult.success(terrainLandform);
    }

    @ApiOperation("更新地形地貌信息")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult<?> update(@PathVariable Long id, @RequestBody TerrainLandformDto terrainLandformDto) {
        int count = terrainLandformService.update(id, terrainLandformDto);
        if (count > 0) {
            return CommonResult.success("更新地形地貌信息成功");
        } else {
            return CommonResult.failed("更新地形地貌信息失败");
        }
    }

    @ApiOperation("删除地形地貌信息")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public CommonResult<?> delete(@PathVariable Long id) {
        int count = terrainLandformService.delete(id);
        if (count > 0) {
            return CommonResult.success("删除地形地貌信息成功");
        } else {
            return CommonResult.failed("删除地形地貌信息失败");
        }
    }

    @ApiOperation("查询所有地形地貌信息")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<List<TerrainLandform>> listAll() {
        List<TerrainLandform> terrainLandformList = terrainLandformService.listAll();
        return CommonResult.success(terrainLandformList);
    }

    @ApiOperation("根据条件查询地形地貌信息")
    @PostMapping("/search")
    @ResponseBody
    public CommonResult<List<TerrainLandform>> search(@RequestBody TerrainLandformSearchDto terrainLandformSearchDto) {
        List<TerrainLandform> terrainLandformList = terrainLandformService.search(terrainLandformSearchDto);
        return CommonResult.success(terrainLandformList);
    }
}
    