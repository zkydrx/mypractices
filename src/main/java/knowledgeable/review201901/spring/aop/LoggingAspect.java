package knowledgeable.review201901.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-13
 * Time: 17:41:11
 * Description:
 */
@Aspect
@Component
public class LoggingAspect
{
    @Before("execution(public * knowledgeable.review201901.spring.aop.*.*(..))")
    public void beforeExecute(JoinPoint joinPoint)
    {
        String classname = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("before Execute! --class name: " + classname + ", method name: " + methodName + " " + args);
    }


    @After("execution(public * knowledgeable.review201901.spring.aop.*.*(..))")
    public void afterExecute(JoinPoint joinPoint)
    {
        String classname = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("after Execute! --class name: " + classname + ", method name: " + methodName + " " + args);
    }

}

