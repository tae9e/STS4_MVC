package com.spring.demo.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.demo.member.vo.MemberVO;

@Mapper
@Repository("memberDAO")
public interface MemberDAO {
	//1.전체 목록
//	@Select("select * from t_member")
	public List selectAllMemberList() throws DataAccessException;
	//2.등록, 저장
	
	public int insertMember(MemberVO memberVO)throws DataAccessException;
	//3.삭제
	public int deleteMember(String id)throws DataAccessException;
	//4.로그인 여부
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
}
