
package com.example.suport.config;
import com.example.suport.Interceptor.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        swagger
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);


        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        //配置server虚拟路径，handler为jsp中访问的目录，locations为files相对应的本地路径
//        registry.addResourceHandler("/files/**").addResourceLocations("file:///C:tomcat9/webapps/image/");
        registry.addResourceHandler("/**").addResourceLocations("file:D:/test/image/");
    }
//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        //config.addAllowedMethod("OPTIONS");
//        //config.addAllowedMethod("HEAD");
//        //config.addAllowedMethod("GET");
//        //config.addAllowedMethod("PUT");
//        //config.addAllowedMethod("POST");
//        //config.addAllowedMethod("DELETE");
//        //config.addAllowedMethod("PATCH");
//        config.addAllowedMethod("*");
////        source.registerCorsConfiguration("*//**", config);
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new CommonInterceptor());
        super.addInterceptors(registry);
    }


}