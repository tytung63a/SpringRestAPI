package com.vn.controller.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vn.entities.AppRole;
import com.vn.entities.AppUser;
import com.vn.entities.UserRole;
import com.vn.repository.AppRoleRepository;
import com.vn.repository.AppUserRepository;
import com.vn.repository.UserRoleRepository;
import com.vn.vo.AppUserVO;

@Controller
public class RegisterController {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private AppRoleRepository appRoleRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/register")
	public String viewRegister(Model model) {
		model.addAttribute("registerForm", new AppUserVO());
		List<AppRole> list = appRoleRepository.findAll();
		model.addAttribute("roles", list);
		return "register";
	}

	@PostMapping("/register")
	public String createRegister(Model model, @ModelAttribute("registerForm") AppUserVO vo) {
		try {
			AppUser appUser = new AppUser();
			// register user
			BeanUtils.copyProperties(vo, appUser);
			String rawPassword = vo.getEncrytedPassword();
			String crytPassword = encoder.encode(rawPassword);
			appUser.setEncrytedPassword(crytPassword);
			appUser = appUserRepository.save(appUser);
			vo.setEncrytedPassword(appUser.getEncrytedPassword());
			vo.setUserId(appUser.getUserId());

			UserRole userRole = new UserRole();
			userRole.setAppRole(appRoleRepository.findById(vo.getRole_id()).get());
			userRole.setAppUser(appUserRepository.findById(vo.getUserId()).get());
			userRoleRepository.save(userRole);
			List<AppRole> list = appRoleRepository.findAll();
			model.addAttribute("roles", list);
			model.addAttribute("message",
					"Đăng ký thành công, tk : " + appUser.getUserName() + "mật khẩu : " + appUser.getEncrytedPassword());
		} catch (Exception e) {
			List<AppRole> list = appRoleRepository.findAll();
			model.addAttribute("roles", list);
			model.addAttribute("message",
					"Đăng ký thất bại, tk đã có trong database");
		}
		return "register";
	}
}
