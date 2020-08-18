/**
 * 
 */
package com.lakeacr.asoms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakeacr.asoms.domain.Centers;
import com.lakeacr.asoms.repository.CenterRepository;

/**
 * @author SURAJ CHANDEL
 *
 */
@Repository
public class CeneterDaoImpl implements CenterDao {

	@Autowired
	CenterRepository centerRepo;
	
	@Override
	public Centers findById(long id) {
		Optional<Centers> subject=centerRepo.findById(id);
		return subject.get() ;
	}

	@Override
	public Centers findByCenterCode(String code) {
		Centers center=centerRepo.findByCenterCode(code);
		return center ;
	}

	@Override
	public List<Centers> findAll() {
		return (List<Centers>) centerRepo.findActiveCenters();
	}

	@Override
	public Centers saveOrUpdate(Centers centers) {
		return centerRepo.save(centers);
	}

	@Override
	public void deleteById(long id) {
		centerRepo.deleteById(id);
	}

	@Override
	public List<Centers> saveAll(List<Centers> center) {
		return (List<Centers>) centerRepo.saveAll(center);
	}

	@Override
	public int countActive() {
		int count= centerRepo.activeCount();
		return count;
	}
	

}
