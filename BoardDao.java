package com.kh.spring.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.model.vo.PageInfo;

@Repository
public class BoardDao {
	// 1.게시글 총 갯수 조회
	public int selectListCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("boardMapper.selectListCount");
		
	}
	// 2.게시글 리스트 조회
	public ArrayList<Board> selectList(SqlSessionTemplate sqlSession, PageInfo pi){
		
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() -1 )*limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList",null,rowBounds);
		
	}
	// 3.게시글 작성하기 서비스
	public int insertBoard(SqlSessionTemplate sqlSession,Board b) {
		
		return sqlSession.insert("boardMapper.insertBoard",b);		
	}
	// 4.게시글 조회수 증가
	public int increaseCount(SqlSessionTemplate sqlSession, int boardNo) {
		
		return sqlSession.update("boardMapper.increaseCount",boardNo);
	}
	// 5.게시글 상세 조회
	public Board selectBoard(SqlSessionTemplate sqlSession, int boardNo) {
		
		return sqlSession.selectOne("boardMapper.selectBoard",boardNo);
	}
	// 6.게시글 삭제 서비스
	public int deleteBoard(SqlSessionTemplate sqlSession, int boardNo) {
		
		return sqlSession.update("boardMapper.deleteBoard",boardNo);
	}
	// 7.게시글 수정 서비스
	public int updateBoard(SqlSessionTemplate sqlSession, Board b) {
		
		return sqlSession.update("boardMapper.updateBoard",b);
	}
	//댓글 조회
	public ArrayList<Reply> selectReplyList(SqlSessionTemplate sqlSession,int boardNo) {
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList",boardNo);
	}
	//댓글 작성
	public int insertReply(SqlSessionTemplate sqlSession, Reply r) {
		
		return sqlSession.insert("boardMapper.insertReply",r);
		
	}
	
	
}
