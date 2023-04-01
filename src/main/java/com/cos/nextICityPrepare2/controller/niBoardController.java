package com.cos.nextICityPrepare2.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cos.nextICityPrepare2.config.auth.PrincipalDetail;
import com.cos.nextICityPrepare2.service.niBoardService;

@Controller
public class niBoardController {
	
	@Autowired 
	private niBoardService boardService;
	
	@GetMapping("/")
	public String niBoardList(@PageableDefault(size=5,sort="id",direction=Sort.Direction.DESC)Pageable pageable,Model model) {
		int pageNumber = boardService.글목록(pageable).getPageable().getPageNumber();
		int totalPages = boardService.글목록(pageable).getTotalPages();
		int pageBlock = 5;
		int startBlockPage = ((pageNumber)/pageBlock)*pageBlock+1;
		int endBlockPage = startBlockPage+pageBlock-1;
		int orgend = endBlockPage;
		endBlockPage = totalPages<endBlockPage?totalPages:endBlockPage;
		
		model.addAttribute("startBlockPage",startBlockPage);
		model.addAttribute("endBlockPage",endBlockPage);
		model.addAttribute("niBoard",boardService.글목록(pageable));
		model.addAttribute("orgend",orgend);
		
		return "niBoard/niBoardList";
	}
	
	
	@RequestMapping("/niBoard/niBoardSaveForm")
	public String niBoardSaveForm() {
		return "niBoard/niBoardSaveForm";
	}
	
	@GetMapping("/niBoard/{id}")
	public String niBoardDetail(@PathVariable int id,Model model,@AuthenticationPrincipal PrincipalDetail princiapl,HttpSession httpSession,
			@PageableDefault(size=5,sort="id",direction=Sort.Direction.DESC)Pageable pageable) {
		boardService.updateCount(id);
		model.addAttribute("niBoard",boardService.글보기(id));
		String str1 = "이전글이 없습니다.";
		String str2 = "다음글이 없습니다.";
		
		/*
		 * if((id-1) == 0) { model.addAttribute("niBoard_pre",str1); }else {
		 * model.addAttribute("niBoard_pre",boardService.글보기(id-1)); }
		 */
		try {
			model.addAttribute("niBoard_pre", boardService.글보기(id - 1));
			if ((id - 1) == 0) {
				model.addAttribute("niBoard_pre", str1);
			} else {
				model.addAttribute("niBoard_pre", boardService.글보기(id - 1));
			}
		} catch (IllegalIdentifierException e) {
			model.addAttribute("niBoard_pre", str1);
		}
	
		try {
			model.addAttribute("niBoard_nxt",boardService.글보기(id+1));
		}catch(IllegalIdentifierException e){
			model.addAttribute("niBoard_nxt",str2);
		}
 		return "niBoard/niBoardDetail";
		}
		
	@GetMapping("/niBoard/{id}/niBoardUpdateForm")
	public String niBoardUpdateForm(@PathVariable int id,Model model) {
		model.addAttribute("niBoard",boardService.글보기(id));
		return "niBoard/niBoardUpdateForm";
	}
	

	
	/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/

	
}
