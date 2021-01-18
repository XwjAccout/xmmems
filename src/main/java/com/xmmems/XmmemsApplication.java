package com.xmmems;

import com.xmmems.auth.config.JwtProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.xmmems.mapper")
@EnableConfigurationProperties({JwtProperties.class})
@EnableScheduling
@EnableAsync
public class XmmemsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        //SpringApplication.run(XmmemsApplication.class, args);
        System.setProperty("java.awt.headless", "false");
        //启动项目
        SpringApplicationBuilder builder = new SpringApplicationBuilder(XmmemsApplication.class);
        builder.headless(false);
        builder.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类1
        return builder.sources(XmmemsApplication.class);
    }

}
