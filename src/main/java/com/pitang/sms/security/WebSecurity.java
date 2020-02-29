package com.pitang.sms.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

	
	//feito por anderson
	
	/*private UserDetailsServiceImpl userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurity(UserDetailsServiceImpl userDetailsService,BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
        http.csrf()
		        .disable()
		        .authorizeRequests()
		        .antMatchers("/h2-console**").permitAll()
		        .antMatchers("/user**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ;
    }*/
    
    //feito por jeff
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
        http.csrf()
		        .disable()
		        .authorizeRequests()
		        .antMatchers("/h2-console**").permitAll()
		        .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ;
    }
	
}