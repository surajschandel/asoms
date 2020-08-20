package com.lakeacr.asoms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lakeacr.asoms.domain.HeadExaminer;

public interface HeadExaminerRepository extends CrudRepository<HeadExaminer, Long> {

		
	@Query("SELECT l FROM HeadExaminer l WHERE l.isDeleted = 0")
	List<HeadExaminer> findActiveHeadExaminer();
	
	@Query("SELECT COUNT(l) FROM HeadExaminer l WHERE l.isDeleted = 0")
	int activeCount();

}
