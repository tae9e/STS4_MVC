package com.spring.demo.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.board.service.BoardService;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Override
	public ModelAndView listArticles(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return null;
		
			
			
		}
	

	@Override
	public ModelAndView addNewArticle(MultipartHttpServletRequest mul, HttpServletResponse res) throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView viewArticle(int articleNO, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return null;
	}

	@Override
	public ResponseEntity modArticle(MultipartHttpServletRequest mul, HttpServletResponse res) throws Exception {
		
		return null;
	}

	@Override
	public ResponseEntity removeArticle(int articleNO, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		return null;
	}
	
	//(articleForm, loginForm)
	@RequestMapping(value="/board/*Form.do", method = RequestMethod.GET)
	public  ModelAndView form(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName"); // /board/articleForm   /board/loginForm
		ModelAndView mav = new ModelAndView(); // /board/articleForm.jsp
		mav.setViewName(viewName);
		return mav;
		
	}

}
