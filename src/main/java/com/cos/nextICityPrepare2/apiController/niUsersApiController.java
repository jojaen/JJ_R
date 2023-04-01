package com.cos.nextICityPrepare2.apiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.nextICityPrepare2.model.ResponseDto;
import com.cos.nextICityPrepare2.model.niUsers;
import com.cos.nextICityPrepare2.service.niUsersService;

@RestController
public class niUsersApiController {
	
	@Autowired
	private niUsersService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer>save(@RequestBody niUsers user){
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}

}
