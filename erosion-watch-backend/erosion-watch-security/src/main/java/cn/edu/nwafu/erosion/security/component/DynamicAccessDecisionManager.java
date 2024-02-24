package cn.edu.nwafu.erosion.security.component;

import cn.hutool.core.collection.CollUtil;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * 实现 {@link DynamicAccessDecisionManager} 接口的动态权限决策管理器，用于判断用户是否有访问权限。
 *
 * @author Huang Z.Y.
 */
public class DynamicAccessDecisionManager implements AccessDecisionManager {
    /**
     * 根据认证信息、请求对象和配置属性决定是否允许访问。
     *
     * @param authentication   认证信息
     * @param object           请求对象
     * @param configAttributes 配置属性集合
     * @throws AccessDeniedException               如果访问被拒绝
     * @throws InsufficientAuthenticationException 如果认证不足
     */
    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // 当接口未被配置资源时直接放行
        if (CollUtil.isEmpty(configAttributes)) {
            return;
        }
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute configAttribute = iterator.next();
            //将访问所需资源或用户拥有资源进行比对
            String needAuthority = configAttribute.getAttribute();
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needAuthority.trim().equals(grantedAuthority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("抱歉，您没有访问权限");
    }

    /**
     * 确定该 {@link AccessDecisionManager} 是否支持给定的安全对象类型。
     *
     * @param configAttribute 配置属性
     * @return 如果支持则返回 true，否则返回 false
     */
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    /**
     * 确定该 {@link AccessDecisionManager} 是否支持给定的类。
     *
     * @param aClass 类
     * @return 如果支持则返回 true，否则返回 false
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
