package com.cos.nextICityPrepare2.service;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.nextICityPrepare2.model.niBoard;
import com.cos.nextICityPrepare2.model.niReply;
import com.cos.nextICityPrepare2.model.niUsers;
import com.cos.nextICityPrepare2.repository.niBoardRepository;
import com.cos.nextICityPrepare2.repository.niReplyRepository;

@Service
public class niBoardService {
	
	@Autowired
	private niBoardRepository boardRepository;
	
	@Autowired
	private niReplyRepository replyRepository;
	
	@Transactional(readOnly=true)
	public Page<niBoard>글목록(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly=true)
	public niBoard 글보기(int id) {
		return boardRepository.findById(id).orElseThrow(()->{
		return new IllegalIdentifierException("글 상세보기 실패:아이디를 찾을 수 없습니다.");
	});
	}
	
	
	@Transactional
	public void 글쓰기(niBoard board,niUsers user) {
		board.setCount(0);
		board.setUsername(user);
		boardRepository.save(board);
	}
	
	@Transactional
	public void 글수정(int id,niBoard requestBoard) {
		niBoard board = boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 찾기 실패 아이디를 찾을 수 없습니다.");
		});
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	}
	
	@Transactional
	public void 글삭제(int id) {
		boardRepository.deleteById(id);
	}
	
	/* , *//* , *//* , *//* , *//* , *//* , *//* , *//* , *//* , *//* , *//* , *//* , */
	
	@Transactional
	public void 댓글쓰기(niUsers user,int niBoardId,niReply requestReply) {
		niBoard board = boardRepository.findById(niBoardId).orElseThrow(()->{
			return new IllegalArgumentException("댓글쓰기 실패:게시글 아이디를 찾을 수 없습니다.");
		});
		requestReply.setUsername(user);
		requestReply.setNiBoard(board);
		
		replyRepository.save(requestReply);
	}
	
	@Transactional
	public void 댓글수정(int niReplyId,niReply requestReply) {
		niReply reply=replyRepository.findById(niReplyId).orElseThrow(()->{
			return new IllegalArgumentException("댓글수정 실패:댓글 아이디를 찾을 수 없습니다."+niReplyId);
		});
		reply.setContent(requestReply.getContent());
	}
	
	@Transactional
	public void 댓글삭제(int niReplyId) {
		replyRepository.deleteById(niReplyId);
	}
	
	/* , *//* , *//* , *//* , *//* , *//* , *//* , *//* , *//* , *//* , *//* , *//* , */

	@Transactional
	public void updateCount(int id) {
		boardRepository.updateCount(id);
	}
	
	
}
