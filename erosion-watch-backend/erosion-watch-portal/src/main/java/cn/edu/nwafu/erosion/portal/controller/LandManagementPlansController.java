package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonPage;
import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.model.LandManagementPlans;
import cn.edu.nwafu.erosion.portal.domain.dto.LandManagementPlansDto;
import cn.edu.nwafu.erosion.portal.domain.dto.LandManagementPlansSearchDto;
import cn.edu.nwafu.erosion.portal.service.LandManagementPlansService;
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
@Slf4j
@Api(tags = "LandManagementPlansController")
@Tag(name = "LandManagementPlansController", description = "土地管理计划管理")
@Controller
@RequestMapping("/land-management-plans")
public class LandManagementPlansController {
    @Autowired
    private LandManagementPlansService landManagementPlansService;

    @ApiOperation("添加土地管理计划")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<?> add(@RequestBody LandManagementPlansDto landManagementPlansDto) {
        int count = landManagementPlansService.add(landManagementPlansDto);
        if (count > 0) {
            return CommonResult.success(null, "添加土地管理计划成功");
        } else {
            return CommonResult.failed("添加土地管理计划失败");
        }
    }

    @ApiOperation("根据ID查询土地管理计划")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<LandManagementPlans> getLandManagementPlanById(@PathVariable Long id) {
        LandManagementPlans landManagementPlan = landManagementPlansService.getById(id);
        return CommonResult.success(landManagementPlan);
    }

    @ApiOperation("更新土地管理计划")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult<?> update(@PathVariable Long id, @RequestBody LandManagementPlansDto landManagementPlansDto) {
        int count = landManagementPlansService.update(id, landManagementPlansDto);
        if (count > 0) {
            return CommonResult.success("更新土地管理计划成功");
        } else {
            return CommonResult.failed("更新土地管理计划失败");
        }
    }

    @ApiOperation("删除土地管理计划")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public CommonResult<?> delete(@PathVariable Long id) {
        int count = landManagementPlansService.delete(id);
        if (count > 0) {
            return CommonResult.success("删除土地管理计划成功");
        } else {
            return CommonResult.failed("删除土地管理计划失败");
        }
    }

    @ApiOperation("查询所有土地管理计划")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<LandManagementPlans>> listAll(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<LandManagementPlans> landManagementPlansList = landManagementPlansService.listAll();
        return CommonResult.success(CommonPage.restPage(landManagementPlansList));
    }

    @ApiOperation("根据条件查询土地管理计划")
    @PostMapping("/search")
    @ResponseBody
    public CommonResult<CommonPage<LandManagementPlans>> search(@RequestBody LandManagementPlansSearchDto searchDto,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<LandManagementPlans> landManagementPlansList = landManagementPlansService.search(searchDto);
        return CommonResult.success(CommonPage.restPage(landManagementPlansList));
    }
}
    