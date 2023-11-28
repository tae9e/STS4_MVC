package com.spring.demo.board.service;

import java.util.List;
import java.util.Map;
import com.spring.demo.board.vo.ArticleVO;

public interface BoardService {
	// 1. 글 목록(select *)
	//	  목록을 가져오기만 하면 됨 
	public List<ArticleVO> listArticles() throws Exception;

	// 2. 등록, 저장(insert)
	public int addNewArticle(Map articleMap) 
			throws Exception;

	// 3. view
	public ArticleVO viewArticle(int ArticleNO) throws Exception;
	
	
	// 4. 글 수정
	public void modArticle(Map articleNO) 
			throws Exception;
	
	// 5. 글 삭제
	public void removeArticle(int articleNO) 
			throws Exception;
}
