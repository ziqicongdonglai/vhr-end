package com.example.vhr.config;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

/**
 * @author ke_zhang
 * @create 2020/4/26 19:01
 * @description
 */
@Data
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("微人事管理API")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.vhr.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置页面展示的基本信息：标题、描述、版本、服务条款、联系方式等
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("微人事管理")
                .description("微人事管理 API 操作文档")
                .termsOfServiceUrl("http://localhost:8080")
                .contact(new Contact("ZhangKe", "https://github.com/ziqicongdonglai", "1826213722@qq.com"))
                .version("1.0")
                .build();
    }
}