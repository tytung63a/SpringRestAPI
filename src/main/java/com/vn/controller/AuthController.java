//package com.vn.controller;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.vn.entities.AppUser;
//import com.vn.entities.UserRole;
//import com.vn.repository.AppRoleRepository;
//import com.vn.repository.AppUserRepository;
//import com.vn.repository.UserRoleRepository;
//import com.vn.vo.AppUserVO;
//
//@RestController
//public class AuthController {
//	
//	@Autowired
//	private AppUserRepository appUserRepository;
//	
//	@Autowired
//	private UserRoleRepository userRoleRepository;
//	
//	@Autowired
//	private AppRoleRepository appRoleRepository;
//	
//	@Autowired
//	private BCryptPasswordEncoder encoder;
//
//	@PostMapping("/register")
//	public AppUserVO register(@RequestBody AppUserVO vo) {
//		//cryt Passowrd
//		AppUser appUser = new AppUser();
//		
//		// register user
//		BeanUtils.copyProperties(vo, appUser);
//		String rawPassword = vo.getEncrytedPassword();
//		String crytPassword = encoder.encode(rawPassword);
//		appUser.setEncrytedPassword(crytPassword);
//		appUser = appUserRepository.save(appUser);
//		vo.setEncrytedPassword(appUser.getEncrytedPassword());
//		vo.setUserId(appUser.getUserId());
//		
//		UserRole userRole = new UserRole();
//		userRole.setAppRole(appRoleRepository.findById(vo.getRole_id()).get());
//		userRole.setAppUser(appUserRepository.findById(vo.getUserId()).get());
//		userRoleRepository.save(userRole);
//		
//		return vo;
//	}
//}