package com.lakeacr.asoms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lakeacr.asoms.domain.Paper;

public interface PaperRepository extends CrudRepository<Paper, Long> {
	
	@Query("SELECT l FROM Paper l WHERE l.isDeleted = 0")
	List<Paper> findActivePaper();
	
	@Query("SELECT COUNT(l) FROM Paper l WHERE l.isDeleted = 0")
	int activeCount();

}
