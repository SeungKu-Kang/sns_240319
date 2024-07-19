package com.sns.post;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@RestController
public class PostRestController {

//	@PostMapping("/create")
//	public Map<String, Object> create(
//			@RequestParam("content") String content,
//			@RequestParam(value = "file", required = false) MultipartFile file,
//			HttpSession session) {
//		
//		// 글쓴이 번호를 session에서 꺼낸다.
//		int userId = (int)session.getAttribute("userId");
//		String userLoginId = (String)session.getAttribute("userLoginId");
//		
//		// DB insert
//		postBO.addPost()
//		// 응답값
//		
//	}
}
