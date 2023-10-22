package com.example.demo.tutorial.configure;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.demo.tutorial.entity.tuto0006.PostEntity;

//構成クラスとして認識されBeanとして登録
@Configuration
public class PostConfigure {
	@Bean
	public PostEntity post() {
		return new PostEntity("00001",0,"Dummy","this is dummy post");
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
