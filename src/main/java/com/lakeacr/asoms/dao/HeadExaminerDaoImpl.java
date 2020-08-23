/**
 * 
 */
package com.lakeacr.asoms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakeacr.asoms.domain.HeadExaminer;
import com.lakeacr.asoms.repository.HeadExaminerRepository;

/**
 * @author SURAJ CHANDEL
 *
 */
@Repository
public class HeadExaminerDaoImpl implements HeadExaminerDao {

	@Autowired
	HeadExaminerRepository headExaminerRepo;
	
	@Override
	public HeadExaminer findById(long id) {
		Optional<HeadExaminer> subject=headExaminerRepo.findById(id);
		return subject.get() ;
	}

	@Override
	public List<HeadExaminer> findAll() {
		return (List<HeadExaminer>) headExaminerRepo.findActiveHeadExaminer();
	}

	@Override
	public HeadExaminer saveOrUpdate(HeadExaminer headExaminers) {
		return headExaminerRepo.save(headExaminers);
	}

	@Override
	public void deleteById(long id) {
		headExaminerRepo.deleteById(id);
	}

	@Override
	public List<HeadExaminer> saveAll(List<HeadExaminer> headExaminer) {
		return (List<HeadExaminer>) headExaminerRepo.saveAll(headExaminer);
	}

	@Override
	public int countActive() {
		int count= headExaminerRepo.activeCount();
		return count;
	}
	

}
