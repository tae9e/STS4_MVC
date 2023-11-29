package com.spring.demo.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.ResponseEntity;


public interface BoardController {

		// 1. 글 목록(select *)
		public ModelAndView listArticles(HttpServletRequest req,HttpServletResponse res) throws Exception;

		// 2. 등록, 저장(insert)
		public ResponseEntity addNewArticle(MultipartHttpServletRequest mul,HttpServletResponse res) 
				throws Exception;

		// 3. view
		public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO,HttpServletRequest req,HttpServletResponse res) 
				throws Exception;
		
		// 4. 글 수정
		public ResponseEntity modArticle(MultipartHttpServletRequest mul, HttpServletResponse res) 
				throws Exception;
		
		// 5. 글 삭제
		public ResponseEntity removeArticle(@RequestParam("articleNO") int articleNO,HttpServletRequest req,HttpServletResponse res) 
				throws Exception;

	}


