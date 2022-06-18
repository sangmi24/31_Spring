package com.kh.spring.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class Reply {
	
	private int replyNo;//REPLY_NO
	private String replyContent;//REPLY_CONTENT
	private int refBoardNo;//REF_BNO
	private String replyWriter;//REPLY_WRITER
	private String createDate;//CREATE_DATE
	private String status;//STATUS
	

}
