package com.clloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// 扫描mybatis mapper包路径
@MapperScan(basePackages="com.clloud.mapper")
// 扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.clloud", "org.n3r"})
public class Application {
//	@Bean
//	public SpringUtil getSpingUtil() {
//		return new SpringUtil();
//	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
