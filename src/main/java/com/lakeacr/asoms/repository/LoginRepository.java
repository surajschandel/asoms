package com.lakeacr.asoms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lakeacr.asoms.domain.Login;
/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface LoginRepository extends CrudRepository<Login, Long> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Login findById(long id);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	Login findByUserId(long userId);
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<Login> findAllById(long id); 
}
