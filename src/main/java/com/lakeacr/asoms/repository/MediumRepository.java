package com.lakeacr.asoms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lakeacr.asoms.domain.Medium;

public interface MediumRepository extends CrudRepository<Medium, Long> {

	Medium findByMediumCode(String code);

	
	@Query("SELECT l FROM Medium l WHERE l.isDeleted = 0")
	List<Medium> findActiveMediums();
	
	@Query("SELECT COUNT(l) FROM Medium l WHERE l.isDeleted = 0")
	int activeCount();

}
