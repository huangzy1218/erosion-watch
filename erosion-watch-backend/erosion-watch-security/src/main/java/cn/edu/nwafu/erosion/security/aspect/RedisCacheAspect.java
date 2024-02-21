package cn.edu.nwafu.erosion.security.aspect;

import cn.edu.nwafu.erosion.security.annoation.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Redis 缓存切面，防止 Redis 宕机影响正常业务逻辑。
 *
 * @author Huang Z.Y.
 */
@Aspect
@Component
@Order(2)
@Slf4j
public class RedisCacheAspect {
    @Pointcut("execution(public * cn.edu.nwafu.erosion.portal.service.*CacheService.*(..))")
    public void cacheAspect() {
    }

    @Around("cacheAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            // 有 CacheException 注解的方法需要抛出异常
            if (method.isAnnotationPresent(CacheException.class)) {
                throw throwable;
            } else {
                log.error(throwable.getMessage());
            }
        }
        return result;
    }

}
