package com.cos.nextICityPrepare2.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.nextICityPrepare2.model.niUsers;
import com.cos.nextICityPrepare2.repository.niUsersRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {
	
	@Autowired
	private niUsersRepository userRepository;
	
	//스프링이 로그인 요청을 가로챌때 username,psswrod변수 2개를 가로채는데 
	//password 부분 처리는 알아서 한다.
	//username 이 DB에 있는지만 확인해주면 된다.
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		niUsers principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.:"+username);
				});
		return new PrincipalDetail(principal);
	}
}
