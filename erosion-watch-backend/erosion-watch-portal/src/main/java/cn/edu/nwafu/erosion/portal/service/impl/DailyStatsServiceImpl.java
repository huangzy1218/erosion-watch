package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.common.service.RedisService;
import cn.edu.nwafu.erosion.portal.domain.entity.DailyUsageStats;
import cn.edu.nwafu.erosion.portal.mapper.DailyStatsMapper;
import cn.edu.nwafu.erosion.portal.service.DailyStatsService;
import cn.edu.nwafu.erosion.portal.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class DailyStatsServiceImpl extends ServiceImpl<DailyStatsMapper, DailyUsageStats>
        implements DailyStatsService {
    @Autowired
    private DailyStatsMapper dailyStatsMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private MemberService memberService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.key.unique-visit}")
    private String REDIS_KEY_UV;
    @Value("${redis.key.total-visit}")
    private String REDIS_KEY_TV;
    @Value("${redis.key.upload-data}")
    private String REDIS_KEY_UPLOAD;
    @Value("${redis.key.process-data}")
    private String REDIS_KEY_PROCESS;

    @Override
    public void add() {
        DailyUsageStats dailyUsageStats = new DailyUsageStats();
        dailyUsageStats.setDate(new Date());
        Long registerCount = memberService.getRegisterCount();
        String uvKey = REDIS_DATABASE + ":" + REDIS_KEY_UV;
        String tvKey = REDIS_DATABASE + ":" + REDIS_KEY_TV;
        String uploadKey = REDIS_DATABASE + ":" + REDIS_KEY_UPLOAD;
        String processKey = REDIS_DATABASE + ":" + REDIS_KEY_PROCESS;
        Long uvCount = redisService.pfCount(uvKey);
        Integer tvCount = (Integer) redisService.get(tvKey);
        Integer uploadCount = (Integer) redisService.get(uploadKey);
        dailyUsageStats.setRegisteredUserCount(registerCount);
        dailyUsageStats.setUniqueVisitorCount(uvCount);
        dailyUsageStats.setTotalVisitsCount(tvCount);
        dailyUsageStats.setUploadDataCount(uploadCount);
        dailyStatsMapper.insert(dailyUsageStats);
    }
}
    