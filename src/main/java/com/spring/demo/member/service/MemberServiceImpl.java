package com.spring.demo.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.demo.member.dao.MemberDAO;
import com.spring.demo.member.vo.MemberVO;

//@Service("memberService") - MemberServiceImpl을 불러올 때 쓰는 객체 이름
//							  default => memberServiceImpl
//							  다른 경우 => @Service("memberService")
@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED) //commit과 콜백
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	@Override
	public List ListMembers() throws DataAccessException {
		List memberlist = null;
		memberlist = memberDAO.selectAllMemberList(); 
		return memberlist;
	}
	
	//2. insert -> dao로
	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		
		return memberDAO.insertMember(member);
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		
		return memberDAO.deleteMember(id);
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws DataAccessException {
		
		return memberDAO.loginById(memberVO);
	}

}
