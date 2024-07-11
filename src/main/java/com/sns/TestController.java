package com.sns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sns.post.mapper.PostMapper;

@Controller
public class TestController {

	@Autowired
	PostMapper postMapper;
	
	@ResponseBody // view를 찾기않게 하기 위한 어노테이션
	@GetMapping("/test1")
	public String test1() {
		return "<h2>Hello World!</h2>";
	}
	
	@ResponseBody
	@GetMapping("/test2")
	public Map<String,Object> test2() {
		Map<String, Object> map = new HashMap<>();
		map.put("a", 1111);
		map.put("b", 2222);
		map.put("c", 3333);
		return map;
	}
	
	@GetMapping("/test3")
	public String test3() {
		// templates/test/test.html
		return "test/test";
	}
	
	@ResponseBody // 안쓰면 500error뜸
	@GetMapping("/test4")
	public List<Map<String,Object>> test4() {
		return postMapper.selectPostListTest();
	}
}
