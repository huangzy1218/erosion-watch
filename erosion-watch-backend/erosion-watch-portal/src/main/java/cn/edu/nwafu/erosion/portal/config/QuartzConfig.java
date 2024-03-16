package cn.edu.nwafu.erosion.portal.config;

import cn.edu.nwafu.erosion.portal.task.DailyStatsJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时任务配置类
 *
 * @author Huang Z.Y.
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        // 指定任务描述具体的实现类
        return JobBuilder.newJob(DailyStatsJob.class)
                // 指定任务的名称
                .withIdentity("DailyStatsJob")
                // 任务描述
                .withDescription("每日数据统计")
                // 每次任务执行后进行存储
                .storeDurably()
                .build();
    }

    // 触发器
    @Bean
    public Trigger trigger() {
        //创建触发器
        return TriggerBuilder.newTrigger()
                // 绑定上述的工作任务
                .forJob(jobDetail())
                // 每天 23:59:59 执行一次
                .withSchedule(CronScheduleBuilder.cronSchedule("59 59 23 * * ?"))
                .build();
    }
}
    