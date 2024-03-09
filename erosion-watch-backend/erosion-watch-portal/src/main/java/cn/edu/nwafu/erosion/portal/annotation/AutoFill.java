package cn.edu.nwafu.erosion.portal.annotation;

import cn.edu.nwafu.erosion.portal.enums.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Huang Z.Y.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    // 数据库操作类型：UPDATE，INSERT
    OperationType value();
}
