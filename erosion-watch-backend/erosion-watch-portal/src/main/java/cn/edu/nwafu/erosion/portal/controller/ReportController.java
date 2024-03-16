package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.portal.domain.vo.UserReportVo;
import cn.edu.nwafu.erosion.portal.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
@Api(tags = "统计报表相关接口")
@Tag(name = "ReportController", description = "统计报表相关接口")
@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 用户情况统计
     */
    @GetMapping("/user-statistics")
    public CommonResult<UserReportVo> memberStatistics(@DateTimeFormat(pattern = "yyyy-MM-dd") Date begin,
                                                       @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        return CommonResult.success(reportService.getMemberStatistics(begin, end));
    }

}
    