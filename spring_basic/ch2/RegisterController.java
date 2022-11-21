package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o 자동 import
public class RegisterController {
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST}) // 신규회원 가입 화면
	public String register( ) {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	} // registerForm 화면만 보여주고 실제로 하는일이 없기 때문에 viewcontroller로 바꿔보려한다. 
	  // spring 웹관련 설정파일인 servlet-context.xml 파일에서 적용 <view-controller path="/register/add" view-name="registerForm"/>
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // GET방식으로 접근불가
	@PostMapping("/register/save") // PostMapping POST방식으로만 접근가능 spring 4.3부터 사용가능
	public String save(User user, Model m) throws Exception{ 
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add";
//			return "redirect:/register/add?msg="+msg; // URL재작성(rewriting) 위 두줄과 같다.
		}
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
	return false;
	}
}
