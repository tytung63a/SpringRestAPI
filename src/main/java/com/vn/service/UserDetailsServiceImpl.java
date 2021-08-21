package com.vn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vn.entities.AppUser;
import com.vn.entities.UserRole;
import com.vn.repository.AppUserRepository;
import com.vn.repository.UserRoleRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    //lớp UserDetailsServiceImpl này phải ghi đè phương thức của UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUserName(userName); //tìm kiếm xem có user trong database 

        // nếu ko tìm thấy trả về exception báo ko tìm thấy
        if (appUser == null) {
            System.out.println("User ko tìm thấy " + userName);
            throw new UsernameNotFoundException("User " + userName + " ko tìm thấy trong database");
        }

        //tìm các role trong bảng userrole của user Appuser
        List<UserRole> userRoles = userRoleRepository.findByAppUser(appUser); 

        //cái này lấy các role và gán vào granted
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        
        //nếu ko null thì ta sẽ duyệt vòng lặp để lấy ra các role
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grantList.add(authority);
            }
        }
        
        //sau khi lấy được username, password, list role ta sẽ trả về userdetails cho class này
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncrytedPassword(), grantList);

        return userDetails;
    }

}