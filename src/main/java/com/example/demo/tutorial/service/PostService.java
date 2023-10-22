package com.example.demo.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.tutorial.entity.tuto0006.PostEntity;

@Service
public class PostService {

	private String baseUrl = "https://jsonplaceholder.typicode.com/posts";
	
	@Autowired
	RestTemplate restTemplate;
	
	public PostEntity[] getAllPostsJson() {
		return restTemplate.getForObject(baseUrl, PostEntity[].class);
	}
	public PostEntity getPostsJson(int id) {
		return restTemplate.getForObject(baseUrl + "/" + id, PostEntity.class);
	}
	
}
