package kr.co.sunnyvale.mvcexam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class GoodsController {

	/*
		http://localhost:8080/goods/{id} : id부분은 바뀔수 있다.
		@PathVariable : path의 일부분을 읽어들일 때 사용
		@RequestHeader : 요청정보중에서 헤더값을 읽을떄 사용, User-Agent헤더가 없으면 User-Agent변수에 기본값으로 "myBrowser"를 설정

	*/
	@GetMapping("/goods/{id}")
	public String getGoodsById(@PathVariable(name="id") int id,
							   @RequestHeader(value="User-Agent", defaultValue="myBrowser") String userAgent,
							  HttpServletRequest request,
							  ModelMap model
							  ) {
		
		String path = request.getServletPath();
		
		System.out.println("id : " + id);
		System.out.println("user_agent : " + userAgent);
		System.out.println("path : " + path);
		
		model.addAttribute("id", id);
		model.addAttribute("userAgent", userAgent);
		model.addAttribute("path", path);
		return "goodsById";
	}
}
