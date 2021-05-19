package com.xmmems.controller.monitor.httpcfg;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 这里是请求第三方http窗口的配置，主要是与数据审核打标识与还原有关
 */
@Configuration
@Getter
public class RestTemplateConfig {

    @Value("${httpcfg.urlprefix}")
    private String urlPrefix;
    @Value("${httpcfg.use}")
    private boolean use;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(simpleClientHttpRequestFactory());
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }

}
