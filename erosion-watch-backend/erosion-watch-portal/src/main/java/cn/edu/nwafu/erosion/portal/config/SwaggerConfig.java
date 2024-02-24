package cn.edu.nwafu.erosion.portal.config;

import cn.edu.nwafu.common.config.BaseSwaggerConfig;
import cn.edu.nwafu.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 相关配置。
 *
 * @author Huang Z.Y.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("cn.edu.nwafu.erosion.portal.controller")
                .title("erosion-watch前台系统")
                .description("erosion-watch前台相关接口文档")
                .contactName("Huang Z.Y.")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }
}
    