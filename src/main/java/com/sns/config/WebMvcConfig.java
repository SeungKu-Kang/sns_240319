package com.sns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sns.common.FileManagerService;

@Configuration //설정을 위한 Spring bean
public class WebMvcConfig implements WebMvcConfigurer{

	// 이미지 path와 서버에 업로드된 실제 이미지와 매핑 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry
		.addResourceHandler("/images/**") // web path
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH);
	}
}
