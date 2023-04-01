package com.cos.nextICityPrepare2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.nextICityPrepare2.config.auth.PrincipalDetailService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Configuration  //@Configuration 어노테이션은 자바 클래스를 스프링의 빈 구성 클래스로 지정하는 역할을 합니다.
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@RequiredArgsConstructor
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	//시큐리티가 대신 로그인을 해주는데, password를 가로채기를 하는데
	//해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
	//같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있다.
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
		//패스워드 인코더가 encodePWD라는 것을 null자리의 오브젝트에게 알려줘야한다.
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable() //csrf토큰 비활성화(테스트시 걸어두는게 좋다.)
			.authorizeRequests()
			.antMatchers("/","/auth/**","/js/**","/css/**","/image/**")
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/auth/loginForm")
			.loginProcessingUrl("/auth/loginProc")
			//스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인한다.
			.defaultSuccessUrl("/");
	}
	
	

}
