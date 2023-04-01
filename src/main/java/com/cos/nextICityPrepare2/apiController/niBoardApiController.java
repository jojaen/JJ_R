package com.cos.nextICityPrepare2.apiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.nextICityPrepare2.config.auth.PrincipalDetail;
import com.cos.nextICityPrepare2.model.ResponseDto;
import com.cos.nextICityPrepare2.model.niBoard;
import com.cos.nextICityPrepare2.model.niReply;
import com.cos.nextICityPrepare2.service.niBoardService;

@RestController
public class niBoardApiController {
	
	@Autowired
	private niBoardService boardService;
	
	@PostMapping("/api/niBoardSave")
	public ResponseDto<Integer>save(@RequestBody niBoard board,@AuthenticationPrincipal PrincipalDetail principal){
		boardService.글쓰기(board, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/niBoard/{id}")
	public ResponseDto<Integer>update(@RequestBody niBoard board,@PathVariable int id){
		boardService.글수정(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/niBoard/{id}")
	public ResponseDto<Integer>delete(@PathVariable int id){
		boardService.글삭제(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
	
	@PostMapping("/api/niBoard/{niBoardId}/niReply")
	public ResponseDto<Integer>replySave(@RequestBody niReply niReply,@PathVariable int niBoardId,@AuthenticationPrincipal PrincipalDetail principal){
		boardService.댓글쓰기(principal.getUser(), niBoardId, niReply);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/niBoardDetail/niReply/{niReplyId}")
	public ResponseDto<Integer>replyUpdate(@PathVariable int niReplyId,@RequestBody niReply reply){
		boardService.댓글수정(niReplyId, reply);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/niBoardDetail/{niBoardId}/niReply/{niReplyId}")
	public ResponseDto<Integer>replyDelete(@PathVariable int niReplyId){
		boardService.댓글삭제(niReplyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
}
