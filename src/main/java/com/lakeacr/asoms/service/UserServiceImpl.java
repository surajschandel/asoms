package com.lakeacr.asoms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.repository.UserRepository;
/**
 * 
 * @author SURAJ CHANDEL
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User findByUserId(long userId) {
		// TODO Auto-generated method stub
		return userRepo.findByUserId(userId);
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(userName);
	}

	@Override
	public User userExists(String userName, String password) {
		// TODO Auto-generated method stub
		return userRepo.findByUserNameAndPassword(userName, password);
	}

}
