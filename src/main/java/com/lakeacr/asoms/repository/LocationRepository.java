package com.lakeacr.asoms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lakeacr.asoms.domain.Locations;

public interface LocationRepository extends CrudRepository<Locations, Long> {

	Locations findByLocationCode(String locationCode);

	
	@Query("SELECT l FROM Locations l WHERE l.isDeleted = 0")
	List<Locations> findActiveLocations();

}
