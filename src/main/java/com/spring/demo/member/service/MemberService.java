package com.spring.demo.member.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.demo.member.vo.MemberVO;

public interface MemberService {
	// 1.전체 목록
	public List ListMembers() throws DataAccessException;

	// 2.등록, 저장
	public int addMember(MemberVO member) throws DataAccessException;

	// 3.삭제
	public int removeMember(String id) throws DataAccessException;

	// 4.로그인 여부
	public MemberVO login(MemberVO memberVO) throws DataAccessException;



	
}
