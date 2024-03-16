package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.portal.domain.vo.UserReportVo;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
public interface ReportService {
    UserReportVo getMemberStatistics(Date begin, Date end);
}
    