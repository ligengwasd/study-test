package com.ydb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@MapperScan(basePackages = "com.ydb.dao.mapper")
@EnableSwagger2
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Value("${swagger.host}")
	String swaggerHost;

	@Value("${swagger.scheme}")
	String swaggerScheme;

	@Value("${swagger.basepath}")
	String basepath;

	@Bean
	public Docket createRestApi() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("这是swagger文档title")
				.description("这是swagger文档des详解")
				.version("1.0")
				.build();
		Set<String> set = new HashSet<String>();
		set.add(swaggerScheme);

		return new Docket(DocumentationType.SWAGGER_2)
				.host(swaggerHost)
				.pathMapping(basepath)
				.protocols(set)
				.ignoredParameterTypes(Pageable.class)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ydb.controller"))
				.paths(PathSelectors.any())
				.build();
	}
}
