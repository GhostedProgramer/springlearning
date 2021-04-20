package com.billy.annotation;

import com.billy.ioc.TestBeanIOC;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveInterceptor implements HandlerInterceptor {

    @Autowired
    TestBeanIOC testBeanIOC;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request,
                             @NotNull HttpServletResponse response,
                             @NotNull Object handler) throws Exception {
        System.out.println("into interceptor");
        if (!(handler instanceof HandlerMethod)) {
            System.out.println("is not a method");
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        NeedApprove needApprove = handlerMethod.getMethod().getAnnotation(NeedApprove.class);
        if (needApprove != null) {
            System.out.println("执行流程逻辑");
            testBeanIOC.test();
            return true;
        }
        System.out.println("is null");
        return true;
    }

}
