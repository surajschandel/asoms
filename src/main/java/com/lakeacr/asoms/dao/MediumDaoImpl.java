/**
 * 
 */
package com.lakeacr.asoms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakeacr.asoms.domain.Medium;
import com.lakeacr.asoms.repository.MediumRepository;

/**
 * @author SURAJ CHANDEL
 *
 */
@Repository
public class MediumDaoImpl implements MediumDao {

	@Autowired
	MediumRepository mediumRepo;
	
	@Override
	public Medium findById(long id) {
		Optional<Medium> optional=mediumRepo.findById(id);
		return optional.get() ;
	}

	@Override
	public Medium findByLocationCode(String code) {
		return mediumRepo.findByMediumCode(code) ;
	}

	@Override
	public List<Medium> findAll() {
		return (List<Medium>) mediumRepo.findActiveMediums();
	}

	@Override
	public Medium saveOrUpdate(Medium Medium) {
		return mediumRepo.save(Medium);
	}

	@Override
	public void deleteById(long id) {
		mediumRepo.deleteById(id);
	}

	@Override
	public List<Medium> saveAll(List<Medium> scanningLocation) {
		return (List<Medium>) mediumRepo.saveAll(scanningLocation);
	}

	@Override
	public int countActive() {
		int count= mediumRepo.activeCount();
		return count;
	}
	

}
