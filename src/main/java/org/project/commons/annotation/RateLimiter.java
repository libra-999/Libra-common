package main.java.org.project.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.enums.LimitType;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter
{

    String key() default CacheConstants.RATE_LIMIT_KEY;

    int time() default 60;

    int count() default 100;

    LimitType limitType() default LimitType.DEFAULT;
}
