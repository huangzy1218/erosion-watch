package cn.edu.nwafu.erosion.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * 动态权限相关业务接口。
 *
 * @author Huang Z.Y.
 */
public interface DynamicSecurityService {
    /**
     * 加载资源 ANT 通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
