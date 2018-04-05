package kr.co.sunnyvale.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {

	// 컨트롤러의 메소드, 컨트롤러가 리턴하는 정보는 view에 대한 정보
	// 컨트롤러의 메소드
	// String or ModelAndView 메소드이름( 파라미터 )
	// InternalResourceViewResolver 가 사용된다.
	// http://localhost:8080/plusform (text/html 을 요청)
	// /WEB-INF/views/ + lpusform(view name) + .jsp
	// jsp를 객체로 삼을수 있는 객체가 있다.
	@GetMapping(path = "/plusform")
	public String plusform() {
		return "plusForm";
	}

	/*
		HttpServletRequest, HttpServletResponse, HttpSession 등을 파라미터에 적어주면
		dispatcherservlet이 자동으로 값을 넣어준다. 필요한 경우에만 사용한다.
		@RequestParam는 request의 파라미터를 읽을때 사용한다. required=true면 반드시 해당 파라미터가 있어야 한다.
		그런데 파라미터가 전달되지 않으면 400오류 ( Bad request )가 발생한다.
		원래 파라미터는 값이 String이다. String이 아닌 type을 적으면 자동으로 형변환한다.
		형변환을 할 수 없을 경우 400오류(bad request)가 발생한다. param에 문자열 값을 넘기는 경우
		그래서 Exception처리를 때문에 String으로만 받고, 메소드 안에서 형변환을 하는 경우도 많다.
		자동현변환이 항상 좋은건 아니다. 원하는 타입으로 처리해야 할 경우가 있어서

		결과를 jsp에게 전달하려면 ModelMap을 사용한다. ModelMap에 값을 저장하면 jsp에게 전달할 수 있다.
		Serlvet에서 jsp에게 값 전달할 때, request,setAttribuet("이름, "값"); (포워딩할때 request를 통하여 값을 전달했었다.)

	*/
	@PostMapping(path = "/plus")
	public String plus(@RequestParam(name = "value1", required = false, defaultValue = "0") int value1,
			@RequestParam(name = "value2", required = true) int value2, ModelMap modelMap) {

		int result = value1 + value2;
		//3가지 값을 modelMap에 저장한다.
		// ${value1} 더하기 ${value2} (은/는) ${result} 입니다. <- jsp코드, attributeName을 EL문법으로 출력
		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", result);
		return "plusResult"; //view이름이 리턴되면 forward 가 된다.
	}
}

/*
client ----------------------> was
			요청정보
			GET / http1.1 : RequestMethod를 뜻한다.
			헤더정보
			빈줄
			바디

초창기 서블릿 : get, post만 있었다.

http method(Rest API - WEB API(HTTPAPI))
http method
GET - 정보를 요청
POST - 등록
PUT - 수정
DELETE - 삭제

*/


/*

http://localhost:8080/plusform
action의 값이 /로 시작하지 않으면 상대경로가 된다.
http://localhost:8080/ 를 기준으로 하여 plus를 실행한다
http://localhost:8080/plus 에 post 방식으로 요청한다. ( value1, value2가 파라미터로 전달)
<form method="post" action="plus">
value1 : <input type="text" name="value1"><br>
value2 : <input type="text" name="value2"><br>
<input type="submit" value="확인">
</form>

*/


