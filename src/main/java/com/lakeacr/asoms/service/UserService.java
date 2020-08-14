package com.lakeacr.asoms.service;

import com.lakeacr.asoms.domain.User;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */

public interface UserService {

	public User findByUserId(long userId);
	

	public User findByUserName(String userName);
	
	public User userExists(String userName, String password);
	
}
