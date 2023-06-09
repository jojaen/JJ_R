package com.cos.nextICityPrepare2.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.nextICityPrepare2.model.niUsers;

import lombok.Getter;

@Getter
public class PrincipalDetail implements UserDetails{
	private niUsers user;
	
	public PrincipalDetail(niUsers user) {
		this.user=user;
	}
	
	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	//계정이 만료되지 않았는지 리턴된다.(true:만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//계정이 잠겨있지 않았는지 리턴된다(true:잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//비밀번호가 만료되지 않았는지 리턴한다(true:만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//계정이 활성화 되었는지 리턴한다(true:활성화)
	public boolean isEnabled() {
		return true;
	}
	
	//계정이 갖고있는 권한목록은 리턴한다.(권한이 여러개 있을 수 있어서 루프를 돌려야하는데 지금은 한개만한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		Collection<GrantedAuthority>collectors=new ArrayList<>();
		collectors.add(()->{return "ROLE_"+user.getRoles();});
		return collectors;
	}
}
