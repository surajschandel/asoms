package com.lakeacr.asoms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lakeacr.asoms.domain.Examiner;

public interface ExaminerRepository extends CrudRepository<Examiner, Long> {

		
	@Query("SELECT l FROM Examiner l WHERE l.isDeleted = 0")
	List<Examiner> findActiveExaminer();
	
	@Query("SELECT COUNT(l) FROM Examiner l WHERE l.isDeleted = 0")
	int activeCount();

}
