package com.vn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vn.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//AuthenticationManagerBuilder để quản lý thông tin người dùng
		// tìm kiếm User trong Database.
		// userdetailservice mình viết riêng để lấy thông tin user pass và role
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/", "/homepage", "/login", "/logout", "/register").permitAll(); // các
																												// trang
																												// cho
																												// phép

		http.authorizeRequests().antMatchers("/admin/categories/**").access("hasRole('ROLE_ADMIN')"); // chỉ admin được vào
		http.authorizeRequests().antMatchers("/admin/products/**","/loginSuccess").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')"); 

		// đăng nhập ko đúng vai trò thì gọi tới getmaaping bên troller, troller trả về 1 trang ta cấu hình và kèm thông báo
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/deniedPage");

		http.authorizeRequests().and().formLogin()//
				.loginProcessingUrl("/login") // submit của fronend
				.defaultSuccessUrl("/loginSuccess")// đăng nhập thành công getmapping tới url này
				.failureUrl("/loginerror") //đăng nhập sai tên tài khoản mật khẩu thì getmapping tới url này
				.loginPage("/login")	//cấu hình là trang login
				.usernameParameter("username")// //mapper vs input bên form
				.passwordParameter("password")	//mapper vs input bên form
				.and().logout().logoutUrl("/logout") // rquest bên controller
				.logoutSuccessUrl("/logoutOK"); // gọi thành công trả về login và xóa cookie session

	}
}