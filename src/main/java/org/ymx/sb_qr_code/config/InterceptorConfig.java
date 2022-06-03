package org.ymx.sb_qr_code.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.ymx.sb_qr_code.interceptor.AppInterceptor;

import javax.annotation.Resource;

/**
 * @desc:
 * @author: YanMingXin
 * @create: 2022/6/3-9:02
 **/
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    /**
     * 注入自定义拦截器
     */
    @Resource
    private AppInterceptor appInterceptor;

    /**
     * 配置拦截器和拦截、放行路径
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(appInterceptor)
                .addPathPatterns("/**");
    }

}
