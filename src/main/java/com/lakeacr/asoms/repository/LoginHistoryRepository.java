package com.lakeacr.asoms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lakeacr.asoms.domain.LoginHistory;

public interface LoginHistoryRepository extends CrudRepository<LoginHistory, Long> {
	/**
	 * 
	 * @param id
	 * @return
	 */
	LoginHistory findById(long id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<LoginHistory> findAllById(long id);

}
