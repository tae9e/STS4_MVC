package com.spring.demo.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.demo.board.dao.BoardDAO;
import com.spring.demo.board.vo.ArticleVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServciceImpl implements BoardService {
	
	@Autowired //자동 주입
	BoardDAO boardDAO;

	@Override
	public List<ArticleVO> listArticles() throws Exception {
		
		List<ArticleVO> articleList = boardDAO.SelectAllArticleList();
		return articleList;
		
	}

	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		
		int newArticle = boardDAO.insertNewArticle(articleMap);
		return newArticle;
	}

	@Override
	public ArticleVO viewArticle(int ArticleNO) throws Exception {
		ArticleVO articleVO = boardDAO.selectArticle(ArticleNO);
		return articleVO;
	}

	@Override
	public void modArticle(Map articleNO) throws Exception {
		boardDAO.updateArticle(articleNO);
	}

	@Override
	public void removeArticle(int articleNO) throws Exception {
		boardDAO.deleteArticle(articleNO);
		
	}


	

}
