package cn.edu.nwafu.erosion.security.config;

import cn.edu.nwafu.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis相关配置。
 *
 * @author Huang Z.Y.
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {
}
