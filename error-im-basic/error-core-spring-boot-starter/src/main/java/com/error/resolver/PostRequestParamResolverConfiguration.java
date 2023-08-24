package com.error.resolver;


import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author ErrorRua
 * @date 2022/11/07
 * @description:
 */
@Configuration
public class PostRequestParamResolverConfiguration implements WebMvcConfigurer {

    @Resource
    private PostRequestParamResolver postRequestParamResolver;
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(postRequestParamResolver);
    }
}