package cn.edu.nwafu.erosion.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * 动态安全服务接口，用于加载资源 ANT 通配符和资源对应的 MAP。
 *
 * @author Huang Z.Y.
 */
public interface DynamicSecurityService {
    /**
     * 加载资源 ANT(Apache Ant) 通配符和资源对应的 MAP。
     *
     * @return 资源 ANT 通配符和资源对应的 MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
