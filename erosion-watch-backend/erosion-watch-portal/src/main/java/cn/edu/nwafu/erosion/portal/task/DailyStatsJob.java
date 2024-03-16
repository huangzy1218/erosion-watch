package cn.edu.nwafu.erosion.portal.task;

import cn.edu.nwafu.erosion.portal.service.DailyStatsService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Configuration
@Component
@EnableScheduling
public class DailyStatsJob extends QuartzJobBean {
    @Autowired
    private DailyStatsService dailyStatsService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        dailyStatsService.add();
    }
}
    