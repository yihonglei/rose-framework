package com.jpeony.commons.lock.annotation;


import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomerLock {

    /**
     * lock key
     * eg  #arg.id
     */
    String lockKey();

    /**
     * 后缀
     */
    String lockSuffix() default "";

    /**
     * 前缀
     */
    String lockPrefix() default "";

    /**
     * 分割符
     */
    String separator() default "#";

    /**
     * 实现类对应的名称 默认使用 redis
     */
    String lockType() default "";

    /**
     * 是否使用尝试锁
     */
    boolean tryLock() default false;

    /**
     * 最长等待时间。
     * 该字段只有当tryLock()返回true才有效。
     */
    int waitTime() default 0;

    /**
     * 锁超时时间。
     * 超时时间过后，锁自动释放。
     * 建议：
     * 尽量缩简需要加锁的逻辑。
     */
    int leaseTime() default 30;

    TimeUnit timeUnit() default TimeUnit.SECONDS;
    
}
