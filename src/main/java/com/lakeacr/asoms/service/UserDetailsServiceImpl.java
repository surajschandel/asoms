package com.lakeacr.asoms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lakeacr.asoms.domain.MyUserDetails;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User domainUser = userRepository.findByUserName(username);
		if (domainUser == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		logger.debug("User fetched from database in loadUserByUsername method " + domainUser);

		String roles = domainUser.getRole();
		logger.debug("role of the user" + roles);

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roles));

		MyUserDetails customUserDetail=new MyUserDetails();
        customUserDetail.setUser(domainUser);
        customUserDetail.setAuthorities(authorities);
        
		return customUserDetail;
	}

}
