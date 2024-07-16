package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sns.post.Entity.PostEntity;
import com.sns.post.bo.PostBO;

@Controller
public class TimelineController {

	@Autowired
	private PostBO postBO;
	
	@GetMapping("/timeline/timeline-view")
	public String timelineView(Model model) {
		
		// DB 조회
		List<PostEntity> postList = postBO.getPostEntityList(); // JPA이기 때문에 PostEntity
		
		// 모델에 담기
		model.addAttribute("postList", postList);
		
		return "timeline/timeline";
	}
}
