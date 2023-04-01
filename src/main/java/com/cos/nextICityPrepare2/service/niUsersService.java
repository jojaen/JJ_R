package com.cos.nextICityPrepare2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.nextICityPrepare2.model.niUsers;
import com.cos.nextICityPrepare2.repository.niUsersRepository;

@Service
public class niUsersService {

	@Autowired
	private niUsersRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encodeer;
	
	@Transactional
	public void 회원가입(niUsers user) {
		String rawPassword = user.getPassword();
		String encPassword = encodeer.encode(rawPassword);
		user.setPassword(encPassword);
		userRepository.save(user);
	}
	
}
