package com.sns.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sns.like.bo.LikeBO;

import jakarta.servlet.http.HttpSession;

@RestController
public class LikeRestController {

	@Autowired
	private LikeBO likeBO;
	// GET:		/like?postId=13				@RequestParam("postId")
	// 또는
	// GET: 	/like/13 (이번엔 이 방식으로)		@PathVariable
	@RequestMapping("/like/{postId}")
	public Map<String, Object> liketoggle(
			@PathVariable(name = "postId") int postId,
			HttpSession session) {
		
		// 로그인 여부 확인
		// json으로 확인하기
		Map<String, Object> result = new HashMap<>(); // 응답값 내릴때도 사용할 것이기 때문에 위에 작성
		Integer userId = (Integer) session.getAttribute("userId"); // session안에 로그인정보가 들어있기 때문에 session사용
		if (userId == null) {
			// 비로그인인 경우
			result.put("code", 403);
			result.put("error_message", "로그인을 해주세요.");
			return result;
		}
		
		// likeToggle BO 요청
		// 이 과정에서 Autowired
		likeBO.likeToggle(postId, userId); // postId는 @PathVariable(name = "postId")를 통해서 넘어오고 userId는 session을 통해서 넘어왔음
		
		
		
		// 성공에 대한 응답
		result.put("code", 200);
		result.put("result", "성공");
		return result;
		
	}
	
}
