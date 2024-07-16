package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.post.Entity.PostEntity;
import com.sns.post.mapper.PostMapper;

@Service
public class PostBO {

	@Autowired
	private PostMapper postRepository;
	
	// input : X
	// output: 글 목록
	public List<PostEntity> getPostEntityList() {
		return postRepository.findByOrderByIdDesc();
	}
}
