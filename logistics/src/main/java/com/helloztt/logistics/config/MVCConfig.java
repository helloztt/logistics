package com.helloztt.logistics.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by helloztt on 2016/5/7.
 */
@Configuration
@EnableWebMvc
@EnableJpaRepositories(
        basePackages = "com.helloztt.logistics",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
@ImportResource({"classpath:config.xml"})
@ComponentScan({
        "com.helloztt.logistics"
})
@EnableTransactionManagement
public class MVCConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment env;
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * for upload
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/resource/**/*", "image/**/*", "/**/*.html").addResourceLocations("/resource/", "/image/", "/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        converters.add(converter);
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
        registry.viewResolver(viewResolver());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    public ThymeleafViewResolver viewResolver() {

        SpringResourceTemplateResolver  rootTemplateResolver =
                new SpringResourceTemplateResolver();
        rootTemplateResolver.setApplicationContext(this.applicationContext);
        rootTemplateResolver.setPrefix("/");
        rootTemplateResolver.setSuffix(".html");
        rootTemplateResolver.setTemplateMode(TemplateMode.HTML);
        rootTemplateResolver.setCharacterEncoding("UTF-8");
        if (env.acceptsProfiles("!container")) {
            rootTemplateResolver.setCacheable(false);
        } else {
            rootTemplateResolver.setCacheable(true);
        }

        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new SpringSecurityDialect());
        engine.setTemplateResolver(rootTemplateResolver);

        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setOrder(1);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateEngine(engine);
        resolver.setContentType("text/html;charset=utf-8");
        return resolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("message/message");
        return messageSource;
    }

}
