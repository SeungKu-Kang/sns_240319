package com.sns.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.like.mapper.LikeMapper;

@Service
public class LikeBO {

	@Autowired
	private LikeMapper likeMapper;
	
	// input: postId, userId 	output: X
	public void likeToggle(int postId, int userId) {
		// 조회
		int count = likeMapper.selectLikeCountByPostIdUserId(postId, userId);
		
		// 여부 => 삭제 or 추가
		// DB에 있으면 삭제하고 없으면 추가하기
		// count는 0이거나 1임
		if (count > 0) { // db에 존재하는 것 => 삭제
			likeMapper.deleteLikeByPostIdUserId(postId, userId);
		} else { // db에 없기 때문에 추가하기
			likeMapper.addLikeByPostIdUserId(postId, userId);
		}
	}
}
