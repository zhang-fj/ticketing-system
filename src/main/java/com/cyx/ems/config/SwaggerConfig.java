package com.cyx.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static ApiInfo DEFAULT = null;

    @Bean
    public Docket docket(){
        Contact DEFAULT_CONTACT = new Contact("曹跃馨", "http://www.baidu.com", "410177002@qq.com");
        DEFAULT = new ApiInfo(
                "cyx的开发接口",
                "Api Documentation",
                "V-1.0",
                "http://www.baidu.com",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT);
    }

}
