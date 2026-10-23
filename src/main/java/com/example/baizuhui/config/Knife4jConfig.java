package com.example.baizuhui.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author xy
 * SpringDoc OpenAPI 配置
 *
 * 访问地址: http://localhost:9999/swagger-ui/index.html
 */
@Configuration
@Profile({"dev", "test"})
public class Knife4jConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BaiZuHui API")
                        .version("1.0.0")
                        .description("BaiZuHui 项目接口文档"));
    }

    @Bean
    public GroupedOpenApi defaultApi() {
        return GroupedOpenApi.builder()
                .group("baizuhui")
                .packagesToScan("com.baizuhui.controller") // 确保包名正确
                .build();
    }
}