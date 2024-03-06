package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonPage;
import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.model.AreaInfo;
import cn.edu.nwafu.erosion.portal.domain.dto.AreaInfoDto;
import cn.edu.nwafu.erosion.portal.domain.dto.AreaSearchDto;
import cn.edu.nwafu.erosion.portal.service.AreaInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
@Controller
@Api(tags = "AreaInfoController")
@Tag(name = "AreaInfoController", description = "区域信息管理")
@Slf4j
@RequestMapping("/area-info")
public class AreaInfoController {
    @Autowired
    private AreaInfoService areaInfoService;

    @ApiOperation("添加区域信息")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<?> add(@RequestBody AreaInfoDto areaInfoDto) {
        int count = areaInfoService.add(areaInfoDto.getAreaName(), areaInfoDto.getAdministrativeCode(),
                areaInfoDto.getLatitude(), areaInfoDto.getLongitude(),
                areaInfoDto.getArea(), areaInfoDto.getPopulation(), areaInfoDto.getClimateType(),
                areaInfoDto.getTerrainFeature(), areaInfoDto.getLandformFeature(), areaInfoDto.getLandUse());
        if (count > 0) {
            return CommonResult.success(null, "添加区域信息成功");
        } else {
            return CommonResult.failed("添加区域信息失败");
        }
    }

    @ApiOperation("根据ID查询区域信息")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<AreaInfo> getAreaInfoById(@PathVariable Long id) {
        AreaInfo areaInfo = areaInfoService.getById(id);
        return CommonResult.success(areaInfo);
    }

    @ApiOperation("更新区域信息")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult<?> update(@PathVariable Long id, @RequestBody AreaInfoDto areaInfoDto) {
        int count = areaInfoService.update(id, areaInfoDto.getAreaName(), areaInfoDto.getAdministrativeCode(),
                areaInfoDto.getLatitude(), areaInfoDto.getLongitude(),
                areaInfoDto.getArea(), areaInfoDto.getPopulation(),
                areaInfoDto.getClimateType(), areaInfoDto.getTerrainFeature(),
                areaInfoDto.getLandformFeature(), areaInfoDto.getLandUse());
        if (count > 0) {
            return CommonResult.success("更新区域信息成功");
        } else {
            return CommonResult.failed("更新区域信息失败");
        }
    }

    @ApiOperation("删除区域信息")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public CommonResult<?> delete(@PathVariable Long id) {
        int count = areaInfoService.delete(id);
        if (count > 0) {
            return CommonResult.success("删除区域信息成功");
        } else {
            return CommonResult.failed("删除区域信息失败");
        }
    }

    @ApiOperation("查询所有区域信息")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<AreaInfo>> listAll(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<AreaInfo> areaInfoList = areaInfoService.listAll();
        return CommonResult.success(CommonPage.restPage(areaInfoList)s);
    }

    @ApiOperation("根据条件查询区域信息")
    @PostMapping("/search")
    @ResponseBody
    public CommonResult<CommonPage<AreaInfo>> search(@RequestBody AreaSearchDto areaSearchDto,
                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<AreaInfo> areaInfoList = areaInfoService.search(areaSearchDto.getAreaName(),
                areaSearchDto.getAdministrativeCode(),
                areaSearchDto.getMinLatitude(), areaSearchDto.getMaxLatitude(),
                areaSearchDto.getMinLongitude(), areaSearchDto.getMaxLongitude());
        return CommonResult.success(CommonPage.restPage(areaInfoList));
    }
}
    