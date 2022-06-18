package com.kh.spring.board.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.model.vo.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 1.게시글 총 갯수 조회
	@Override
	public int selectListCount() {
    
		return boardDao.selectListCount(sqlSession);
		
	}
	// 2.게시글 리스트 조회
	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		
		return boardDao.selectList(sqlSession,pi);
		
	}
	// 3.게시글 작성하기 서비스
	@Override
	public int insertBoard(Board b) {

		return boardDao.insertBoard(sqlSession,b); 
		
	}
	// 4.게시글 조회수 증가
	@Override
	public int increaseCount(int boardNo) {
		
		return boardDao.increaseCount(sqlSession, boardNo);
		
	}
	// 5.게시글 상세 조회
	@Override
	public Board selectBoard(int boardNo) {
		
		return boardDao.selectBoard(sqlSession, boardNo);
	}
	// 6.게시글 삭제 서비스
	@Override
	public int deleteBoard(int boardNo) {
		 
		 return boardDao.deleteBoard(sqlSession,boardNo);
	}
	// 7.게시글 수정 서비스
	@Override
	public int updateBoard(Board b) {
		return boardDao.updateBoard(sqlSession,b);
	}
	// 8.댓글 리스트 조회 서비스 (Ajax)
	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		
		return boardDao.selectReplyList(sqlSession, boardNo);
		
	}
	// 9.댓글 작성 서비스
	@Override
	public int insertReply(Reply r) {
		
		return boardDao.insertReply(sqlSession, r);
		
	}

}
