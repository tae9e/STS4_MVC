package com.spring.demo.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.spring.demo.board.vo.ArticleVO;
//BoardDAOImpl의 역할을 @Mapper가 함
@Mapper
@Repository("boardDAO")
public interface BoardDAO {
	//1. 글 목록
	public List SelectAllArticleList() throws Exception;

	// 2. 등록, 저장(insert)
	public int insertNewArticle(Map articleMap) throws Exception;

	// 3. view
	public ArticleVO selectArticle(int ArticleNO) throws Exception;
	
	
	// 4. 글 수정
	public void updateArticle(Map articleNO) throws Exception;
	
	// 5. 글 삭제
	public void deleteArticle(int articleNO) throws Exception;
	
	public List selectImageFileList(int articleNO) throws Exception;
}
