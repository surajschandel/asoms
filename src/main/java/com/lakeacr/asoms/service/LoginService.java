package com.lakeacr.asoms.service;

import com.lakeacr.asoms.domain.Login;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface LoginService {

	public void save(Login login);
	
	public Login findById(long id);
	
	public Login findByUserId(long userId);
	
	
}
