package cn.edu.nwafu.erosion.security.annoation;

import java.lang.annotation.*;

/**
 * 用于在缓存方法上标记，表示该方法在执行过程中可能会抛出异常，使用者可以根据需要捕获或处理这些异常。
 *
 * @author Huang Z.Y.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
    