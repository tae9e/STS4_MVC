package com.spring.demo.board.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component("articleVO")
public class ArticleVO {
	private int level;
	
	//테이블
	private int articleNO;
	private String title;
	private String content;
	private String imageFileName;
	private String parentNO;
	private Date writeDate;
	private String id; //member의 기본키
	
	
}
