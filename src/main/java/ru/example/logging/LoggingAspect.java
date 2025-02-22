package ru.example.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(Logging) && execution(* *(..))")
    public void methodsAnnotatedWithLogging() {}

    @Before("methodsAnnotatedWithLogging()")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        StringBuilder message = new StringBuilder();
        message.append("executed method: ").append(methodName);

        if (args.length > 0) {
            message.append(", params: ");
            for (int i = 0; i < args.length; i++) {
                if (i > 0) message.append(", ");
                message.append(args[i] != null ? args[i].toString() : "null");
            }
        }

        System.out.println(message);
    }
}
