//package com.lakeacr.asoms.security;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import com.lakeacr.asoms.domain.User;
//import com.lakeacr.asoms.service.UserService;
///**
// * 
// * @author SURAJ CHANDEL
// *
// */
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    public UserService userService;
//
//    public CustomAuthenticationProvider() {
//        super();
//    }
//
//    // API
//    @Override
//    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
//        final String name = authentication.getName();
//        final String password = authentication.getCredentials().toString();
//        System.out.println("User="+name + " : " + password);
//        User loggedInUser = userService.findByUserName(name);
//        if (loggedInUser != null && password.trim().equals("")) {
//            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
//            grantedAuths.add(new SimpleGrantedAuthority("Admin"));
//            grantedAuths.add(new SimpleGrantedAuthority("User"));
//            final UserDetails principal = new org.springframework.security.core.userdetails.User(name, password, grantedAuths);
//            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
//            return auth;
//        } else if (loggedInUser != null && loggedInUser.getPassword().equalsIgnoreCase(password)) {
//            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
//            grantedAuths.add(new SimpleGrantedAuthority("Admin"));
//            grantedAuths.add(new SimpleGrantedAuthority("User"));
//            final UserDetails principal = new org.springframework.security.core.userdetails.User(name, password, grantedAuths);
//            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
//            return auth;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public boolean supports(final Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//
//}
