package org.ymx.sb_qr_code.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc: 拦截器
 * @author: YanMingXin
 * @create: 2022/6/3-8:49
 **/
@Component
public class AppInterceptor implements HandlerInterceptor {

    @Value("${auth.http.header.key}")
    private String key;

    @Value("${auth.http.header.value}")
    private String value;

    @Value("${auth.http.enable}")
    private boolean enable;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!enable) {
            return true;
        }
        if (ObjectUtils.isEmpty(key) || ObjectUtils.isEmpty(value)) {
            return false;
        }
        String header = request.getHeader(key);
        if (header != value) {
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
