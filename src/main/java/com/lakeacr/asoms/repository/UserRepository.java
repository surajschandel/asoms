/**
 * 
 */
package com.lakeacr.asoms.repository;

import org.springframework.data.repository.CrudRepository;
import com.lakeacr.asoms.domain.User;

/**
 * @author SURAJ CHANDEL
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	/**
	 * 
	 * @param teamId
	 * @return
	 */
	User findByUserId(long userId);
	
	/**
	 * 
	 * @param teamId
	 * @return
	 */
	User findByUserName(String userName);
	

	User findByUserNameAndPassword(String userName, String password);
}
