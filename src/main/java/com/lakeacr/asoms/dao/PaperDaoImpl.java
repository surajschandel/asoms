/**
 * 
 */
package com.lakeacr.asoms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakeacr.asoms.domain.Paper;
import com.lakeacr.asoms.repository.PaperRepository;

/**
 * @author SURAJ CHANDEL
 *
 */
@Repository
public class PaperDaoImpl implements PaperDao {

	@Autowired
	PaperRepository paperRepo;
	
	@Override
	public Paper findById(long id) {
		Optional<Paper> subject=paperRepo.findById(id);
		return subject.get() ;
	}	

	@Override
	public List<Paper> findAll() {
		return (List<Paper>) paperRepo.findActivePaper();
	}

	@Override
	public Paper saveOrUpdate(Paper centers) {
		return paperRepo.save(centers);
	}

	@Override
	public void deleteById(long id) {
		paperRepo.deleteById(id);
	}

	@Override
	public List<Paper> saveAll(List<Paper> center) {
		return (List<Paper>) paperRepo.saveAll(center);
	}

	@Override
	public int countActive() {
		int count= paperRepo.activeCount();
		return count;
	}
	

}
