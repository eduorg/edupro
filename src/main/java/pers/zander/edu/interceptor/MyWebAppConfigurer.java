package pers.zander.edu.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 
 * @author zhaozhao
 * @time 2016-3-23 下午5:17:56
 */
@Configuration
public class MyWebAppConfigurer 
        extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
//    	registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");

    	
//    	registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/login/**");
        super.addInterceptors(registry);
    }

}
