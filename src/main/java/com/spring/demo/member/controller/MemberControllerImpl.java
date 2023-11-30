package com.spring.demo.member.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.demo.member.service.MemberService;
import com.spring.demo.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
//	ModelAndView: Model과 비슷.. 데이터를 넣어서 jsp에 넘겨주는 것
//	시작: http://localhost:8090/member/listMembers.do => 목록내용 + 회원입력화면 버튼
	
	//외부에서 Service와 VO 주입
	@Autowired
	private MemberService memberService;

	@Autowired
	MemberVO memberVO;

	//0. main- 기본형
		//http://localhost:8090/main.do 또는
		//http://localhost:8090
		//   =>> main.jsp
		@GetMapping({"/","/main.do"})
		public String main(HttpServletRequest r, HttpServletResponse p) {
			return "main";
		}

//		0. main- Interceptor 사용
//		@GetMapping({"/","/main.do"})
//		public ModelAndView main(HttpServletRequest r, HttpServletResponse p) {
//			String viewName = (String) r.getAttribute("viewName");
//			System.out.println("controllerImpl viewName: " + viewName);
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName(viewName);
//			return mav;
//		}

		
		//1-1.목록 보기
//		@Override
//		@RequestMapping(value="/member/listMembers.do", method = RequestMethod.GET)
//		public ModelAndView ListMembers(HttpServletRequest r, HttpServletResponse p) throws Exception {
//			List memberList = memberService.ListMembers();
//			ModelAndView mav =  new ModelAndView("/member/listMembers");//listMembers.jsp
//			mav.addObject("memberList",memberList);
//			return mav;
//		}
		//1-2.목록 보기-Interceptor 사용
		@Override
		@RequestMapping(value="/member/listMembers.do", method = RequestMethod.GET)
		public ModelAndView ListMembers(HttpServletRequest r, HttpServletResponse p) throws Exception {
			String viewName = (String) r.getAttribute("viewName");//Interceptor-preHandle setAttribute받음
			System.out.println("viewName???" + viewName);
			List memberList = memberService.ListMembers();
			ModelAndView mav =  new ModelAndView(viewName);//listMembers.jsp
			mav.addObject("memberList",memberList);
			return mav;
		}
		
		//2. 회원가입 입력
		@RequestMapping(value="/member/*Form.do", method = RequestMethod.GET)
		public  ModelAndView form(@RequestParam(value="result",required = false) String result,  
//				required = false => 처음 값은 null
				@RequestParam(value="action",required = false) String action,
				HttpServletRequest r, HttpServletResponse p) {
			String viewName = (String) r.getAttribute("viewName");
			HttpSession session = r.getSession();
			session.setAttribute("action", action);
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName(viewName);
			return mav;
			
		}
//	// 2.회원가입 입력-Get (단순 입력)
//	@GetMapping("/member/*Form.do")
//	public ModelAndView form() {
//		ModelAndView mav = new ModelAndView("/member/memberForm");
//		mav.addObject("member", membervo);
//		return mav;
//	}

	// 3. insert -> Post
	// @ModelAttribute("member") MemberVO memberVO 내용 전달 시 memberVO의 이름이 member
//								 날라오는 속성의 이름이 member, 그 이름을 MemberVO의 변수 member 안에 넣음
	// throw Exception은 위에 에러 전달
	@Override
	@PostMapping("/member/addMember.do")
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		int result = 0;
		// String id, String pwd, String name, String email,Date joinDate

		result = memberService.addMember(member);
		//추가된 멤버가 listMembers.jsp에 반영
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	
	//4.삭제 - listMembers.jsp로부터 데이터 전달받음
	@Override
	@GetMapping("/member/removemember.do")
	public ModelAndView removeMember(String id, HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, 
			RedirectAttributes rAttr, 
			HttpServletRequest request, 
			HttpServletResponse response)
			throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("member/login.do mav" + mav);
		
		memberVO =  memberService.login(member);
		if(memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);
			System.out.println("MemberController의 member의 값은? " + member);
			session.setAttribute("isLogOn", true);
			System.out.println("session");
			
			String action = (String) session.getAttribute("action");
			session.removeAttribute("action");
			if(action != null) {
				mav.setViewName("redirect:"+action);
			}else {
				mav.setViewName("redirect:/member/listMembers.do");
			}
		}else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/member/loginForm.do");
		}	
		return mav;
	}

	@Override
	@RequestMapping(value="/member/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest r, 
			                 HttpServletResponse p) throws Exception {
		HttpSession session = r.getSession();
		session.removeAttribute("member");
		session.setAttribute("isLogOn", false);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
	}

}