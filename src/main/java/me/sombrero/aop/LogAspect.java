package me.sombrero.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 애스펙트는 스프링 빈이어야 하기 때문에 @Component를 붙여준다.
 */
@Component
@Aspect
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * @Around 외에도..
     *  어떤 메소드 호출 전/후, 에러가 발생했을 경우,
     *  @annotation이 아닌 빈을 사용하여 특정 빈의 모든 메소드,
     *  또는 표현식을 사용해서 포인트컷을 지정해 줄 수 있다.
     */
    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch("logExecutionTime");
        stopWatch.start();

        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        logger.info("##### " + joinPoint.toString());
        logger.info("##### " + stopWatch.prettyPrint());

        return proceed;
    }

}
