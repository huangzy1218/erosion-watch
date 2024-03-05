package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.model.MonitoringData;
import cn.edu.nwafu.erosion.portal.domain.dto.MonitoringDataDto;
import cn.edu.nwafu.erosion.portal.domain.dto.MonitoringDataSearchDto;
import cn.edu.nwafu.erosion.portal.service.MonitoringDataService;
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
@Api(tags = "MonitoringDataController")
@Tag(name = "MonitoringDataController", description = "监测数据管理")
@RequestMapping("/monitoring-data")
@Controller
public class MonitoringDataController {
    @Autowired
    private MonitoringDataService monitoringDataService;

    @ApiOperation("添加监测数据")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<?> add(@RequestBody MonitoringDataDto monitoringDataDto) {
        int count = monitoringDataService.add(monitoringDataDto);
        if (count > 0) {
            return CommonResult.success(null, "添加监测数据成功");
        } else {
            return CommonResult.failed("添加监测数据失败");
        }
    }

    @ApiOperation("根据ID查询监测数据")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<MonitoringData> getMonitoringDataById(@PathVariable Long id) {
        MonitoringData monitoringData = monitoringDataService.getById(id);
        return CommonResult.success(monitoringData);
    }

    @ApiOperation("更新监测数据")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult<?> update(@PathVariable Long id, @RequestBody MonitoringDataDto monitoringDataDto) {
        int count = monitoringDataService.update(id, monitoringDataDto);
        if (count > 0) {
            return CommonResult.success("更新监测数据成功");
        } else {
            return CommonResult.failed("更新监测数据失败");
        }
    }

    @ApiOperation("删除监测数据")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public CommonResult<?> delete(@PathVariable Long id) {
        int count = monitoringDataService.delete(id);
        if (count > 0) {
            return CommonResult.success("删除监测数据成功");
        } else {
            return CommonResult.failed("删除监测数据失败");
        }
    }

    @ApiOperation("查询所有监测数据")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<List<MonitoringData>> listAll() {
        List<MonitoringData> monitoringDataList = monitoringDataService.listAll();
        return CommonResult.success(monitoringDataList);
    }

    @ApiOperation("根据条件查询监测数据")
    @PostMapping("/search")
    @ResponseBody
    public CommonResult<List<MonitoringData>> search(@RequestBody MonitoringDataSearchDto monitoringDataSearchDto) {
        List<MonitoringData> monitoringDataList = monitoringDataService.search(monitoringDataSearchDto);
        return CommonResult.success(monitoringDataList);
    }
}
    