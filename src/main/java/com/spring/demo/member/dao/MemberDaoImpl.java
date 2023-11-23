package com.spring.demo.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.demo.member.vo.MemberVO;
//Mybatis의 Mapper사용으로 인해 사용하지 않음
//MemberDAOImpl :MemberDAO + member.xml로 분산되어 있는 형태 
//				MemberDAOImpl의 내용이 member.xml(쿼리문 작성)
public class MemberDaoImpl implements MemberDAO {

	@Override
	public List selectAllMemberList() throws DataAccessException {
		
		return null;
	}

	@Override
	public int insertMember(MemberVO member) throws DataAccessException {
		
		return 0;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
	
		return 0;
	}

	@Override
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException {
	
		return null;
	}

}
