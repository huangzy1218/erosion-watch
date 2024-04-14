package cn.edu.nwafu.erosion.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Huang Z.Y.
 */
@SpringBootApplication(scanBasePackages = "cn.edu.nwafu.erosion")
@ComponentScan(basePackages = {"cn.edu.nwafu.erosion", "cn.edu.nwafu.common"})
public class ErosionPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ErosionPortalApplication.class);
    }
}
    