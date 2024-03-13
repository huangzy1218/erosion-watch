package cn.edu.nwafu.erosion.portal.aspect;

import cn.edu.nwafu.erosion.portal.annotation.AutoFill;
import cn.edu.nwafu.erosion.portal.enums.OperationType;
import cn.edu.nwafu.erosion.portal.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 自定义切面，实现公共字段自动填充处理逻辑
 *
 * @author Huang Z.Y.
 */
@Slf4j
@Aspect
@Component
public class AutoFillAspect {
    public static final String SET_CREATE_TIME = "setCreateTime";
    public static final String SET_UPDATE_TIME = "setUpdateTime";
    public static final String SET_CREATE_USER = "setAuthor";
    public static final String SET_UPDATE_USER = "setUpdateUser";
    @Autowired
    private MemberService memberService;

    /**
     * 切入点
     */
    @Pointcut("execution(* cn.edu.nwafu.erosion.portal.mapper.*.*(..)) && @annotation(cn.edu.nwafu.erosion.portal.annotation.AutoFill)")
    public void autoFillPointCut() {
    }

    /**
     * 前置通知，在通知中进行公共字段的赋值
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("开始进行公共字段的自动填充");
        // 获取当前被拦截方法上数据库的操作类型
        // 获取方法签名对象
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取方法注解对象
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        // 获取数据库操作类型
        OperationType operationType = autoFill.value();

        // 获取当前被拦截的方法参数（实体对象）
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];

        // 准备赋值数据
        Date currentTime = new Date();
        String username = "admin";
        //if (memberService.getCurrentMember() != null) {
        //    log.info("currentMember: {}", memberService.getCurrentMember());
        //    username = memberService.getCurrentMember().getUsername();todo
        //}
        // 根据操作类型，为属性赋值
        if (operationType == OperationType.INSERT) {
            try {
                Method setCreateTime = entity.getClass().getDeclaredMethod(SET_CREATE_TIME, Date.class);
                Method setAuthor = entity.getClass().getDeclaredMethod(SET_CREATE_USER, String.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, Date.class);
                //Method setUpdateUser = entity.getClass().getDeclaredMethod(SET_UPDATE_USER, String.class);

                // 通过反射赋值
                setCreateTime.invoke(entity, currentTime);
                setAuthor.invoke(entity, username);
                setUpdateTime.invoke(entity, currentTime);
                //setUpdateUser.invoke(entity, username);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (operationType == OperationType.UPDATE) {
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(SET_UPDATE_USER, String.class);
                // 通过反射赋值
                setUpdateTime.invoke(entity, currentTime);
                setUpdateUser.invoke(entity, username);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
    