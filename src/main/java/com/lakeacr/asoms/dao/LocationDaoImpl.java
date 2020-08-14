/**
 * 
 */
package com.lakeacr.asoms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakeacr.asoms.domain.Locations;
import com.lakeacr.asoms.repository.LocationRepository;
import com.lakeacr.asoms.repository.SubjectRepository;

/**
 * @author SURAJ CHANDEL
 *
 */
@Repository
public class LocationDaoImpl implements LocationDao {

	@Autowired
	LocationRepository locationRepo;
	
	@Override
	public Locations findById(long id) {
		Optional<Locations> subject=locationRepo.findById(id);
		return subject.get() ;
	}

	@Override
	public Locations findByLocationCode(String code) {
		Locations location=locationRepo.findByLocationCode(code);
		return location ;
	}

	@Override
	public List<Locations> findAll() {
		return (List<Locations>) locationRepo.findActiveLocations();
	}

	@Override
	public Locations saveOrUpdate(Locations Locations) {
		return locationRepo.save(Locations);
	}

	@Override
	public void deleteById(long id) {
		locationRepo.deleteById(id);
	}

	@Override
	public List<Locations> saveAll(List<Locations> scanningLocation) {
		return (List<Locations>) locationRepo.saveAll(scanningLocation);
	}

	@Override
	public int countActive() {
		int count= locationRepo.activeCount();
		return count;
	}
	

}
