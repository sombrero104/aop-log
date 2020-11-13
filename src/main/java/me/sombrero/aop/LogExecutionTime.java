package me.sombrero.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target(ElementType.METHOD)
 *  => 메소드에 붙일 애노테이션.
 *
 * @Retention(RetentionPolicy.RUNTIME)
 *  => 이 애노테이션을 언제까지 유지할 것인지.
 *      런타임 때까지 유지를 해야 런타임 시 스프링이 이 애노테이션을 찾을 수 있다.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}
