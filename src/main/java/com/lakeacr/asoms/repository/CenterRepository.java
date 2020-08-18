package com.lakeacr.asoms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lakeacr.asoms.domain.Centers;

public interface CenterRepository extends CrudRepository<Centers, Long> {

	Centers findByCenterCode(String locationCode);

	
	@Query("SELECT l FROM Centers l WHERE l.isDeleted = 0")
	List<Centers> findActiveCenters();
	
	@Query("SELECT COUNT(l) FROM Centers l WHERE l.isDeleted = 0")
	int activeCount();

}
