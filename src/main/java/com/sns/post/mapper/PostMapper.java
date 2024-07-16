package com.sns.post.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sns.post.Entity.PostEntity;

@Mapper
public interface PostMapper {

	public List<Map<String, Object>> selectPostListTest();
	
}
