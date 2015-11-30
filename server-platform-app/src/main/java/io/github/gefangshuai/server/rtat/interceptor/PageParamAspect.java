package io.github.gefangshuai.server.rtat.interceptor;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 分页有关切面
 * Created by gefangshuai on 2015/11/30.
 */
@Aspect
@Component
public class PageParamAspect {

    @Pointcut("execution(* io.github.gefangshuai..*Controller.*(..))")
    private void aspectMethod() {
    }

    /**
     * 处理分页索引page参数
     *
     * @param pjp
     * @param page
     * @return
     */
    @Around(value = "aspectMethod() && args(page,..) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public String doPageIndexCheck(ProceedingJoinPoint pjp, Integer page) {
        try {
            Object[] args = pjp.getArgs();
            if (page <= 1) {
                page = 1;
            }
            args[0] = page - 1;
            return (String) pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
