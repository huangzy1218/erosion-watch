package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.portal.domain.vo.UserReportVo;
import cn.edu.nwafu.erosion.portal.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public UserReportVo getMemberStatistics(Date begin, Date end) {
        return null;
    }
}
    