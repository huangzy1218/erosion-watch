package cn.edu.nwafu.erosion.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis 相关配置。
 *
 * @author Huang Z.Y.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"cn.edu.nwafu.erosion.mapper"})
public class MyBatisConfig {
}