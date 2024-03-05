package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.model.LandUseChangeHistory;
import cn.edu.nwafu.erosion.portal.domain.dto.LandUseChangeHistoryDto;
import cn.edu.nwafu.erosion.portal.domain.dto.LandUseChangeHistorySearchDto;
import cn.edu.nwafu.erosion.portal.service.LandUseChangeHistoryService;
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
@Api(tags = "LandUseChangeHistoryController")
@Tag(name = "LandUseChangeHistoryController", description = "土地利用变更历史管理")
@RequestMapping("/land-use-change-history")
public class LandUseChangeHistoryController {
    @Autowired
    private LandUseChangeHistoryService landUseChangeHistoryService;

    @ApiOperation("添加土地利用变更历史记录")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<?> add(@RequestBody LandUseChangeHistoryDto landUseChangeHistoryDto) {
        int count = landUseChangeHistoryService.add(landUseChangeHistoryDto);
        if (count > 0) {
            return CommonResult.success(null, "添加土地利用变更历史记录成功");
        } else {
            return CommonResult.failed("添加土地利用变更历史记录失败");
        }
    }

    @ApiOperation("根据ID查询土地利用变更历史记录")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<LandUseChangeHistory> getLandUseChangeHistoryById(@PathVariable Long id) {
        LandUseChangeHistory landUseChangeHistory = landUseChangeHistoryService.getById(id);
        return CommonResult.success(landUseChangeHistory);
    }

    @ApiOperation("更新土地利用变更历史记录")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult<?> update(@PathVariable Long id, @RequestBody LandUseChangeHistoryDto landUseChangeHistoryDto) {
        int count = landUseChangeHistoryService.update(id, landUseChangeHistoryDto);
        if (count > 0) {
            return CommonResult.success("更新土地利用变更历史记录成功");
        } else {
            return CommonResult.failed("更新土地利用变更历史记录失败");
        }
    }

    @ApiOperation("删除土地利用变更历史记录")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public CommonResult<?> delete(@PathVariable Long id) {
        int count = landUseChangeHistoryService.delete(id);
        if (count > 0) {
            return CommonResult.success("删除土地利用变更历史记录成功");
        } else {
            return CommonResult.failed("删除土地利用变更历史记录失败");
        }
    }

    @ApiOperation("查询所有土地利用变更历史记录")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<List<LandUseChangeHistory>> listAll() {
        List<LandUseChangeHistory> landUseChangeHistoryList = landUseChangeHistoryService.listAll();
        return CommonResult.success(landUseChangeHistoryList);
    }

    @ApiOperation("根据条件查询土地利用变更历史记录")
    @PostMapping("/search")
    @ResponseBody
    public CommonResult<List<LandUseChangeHistory>> search(@RequestBody LandUseChangeHistorySearchDto landUseChangeHistorySearchDto) {
        List<LandUseChangeHistory> landUseChangeHistoryList = landUseChangeHistoryService.search(landUseChangeHistorySearchDto);
        return CommonResult.success(landUseChangeHistoryList);
    }
}

    