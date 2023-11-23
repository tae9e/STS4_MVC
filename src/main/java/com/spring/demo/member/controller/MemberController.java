package com.spring.demo.member.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.demo.member.vo.MemberVO;

public interface MemberController {
	// 1.전체 목록(select *)
	public ModelAndView ListMembers(HttpServletRequest req,HttpServletResponse res) throws Exception;

	// 2.등록, 저장(insert)
	public ModelAndView addMember(@ModelAttribute("info")MemberVO memberVO,HttpServletRequest req,HttpServletResponse res) 
			throws Exception;

	// 3.삭제(delete)
	public ModelAndView removeMember(@RequestParam("id") String id,HttpServletRequest req,HttpServletResponse res) 
			throws Exception;

	// 4.로그인 여부(select one)
	public ModelAndView login(@ModelAttribute("member") MemberVO memberVO, RedirectAttributes rAttr, 
			HttpServletRequest req,HttpServletResponse res) throws Exception;
	
	// 5.로그아웃
	public ModelAndView logout(HttpServletRequest req,HttpServletResponse res) throws Exception;

	ModelAndView listMembers(HttpServletRequest r, HttpServletResponse p) throws Exception;
}
