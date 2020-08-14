/**
 * 
 */
package com.lakeacr.asoms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakeacr.asoms.domain.Login;
import com.lakeacr.asoms.repository.LoginRepository;

/**
 * @author SURAJ CHANDEL
 *
 */

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepo; 
	
	@Override
	public void save(Login login) {
		loginRepo.save(login);
	}

	@Override
	public Login findById(long id) {		
		return loginRepo.findById(id);
	}

	@Override
	public Login findByUserId(long userId) {
		return loginRepo.findByUserId(userId);
	}

}
