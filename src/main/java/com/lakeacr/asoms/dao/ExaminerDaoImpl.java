/**
 * 
 */
package com.lakeacr.asoms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakeacr.asoms.domain.Examiner;
import com.lakeacr.asoms.repository.ExaminerRepository;

/**
 * @author SURAJ CHANDEL
 *
 */
@Repository
public class ExaminerDaoImpl implements ExaminerDao {

	@Autowired
	ExaminerRepository examinerRepo;
	
	@Override
	public Examiner findById(long id) {
		Optional<Examiner> subject=examinerRepo.findById(id);
		return subject.get() ;
	}

	@Override
	public List<Examiner> findAll() {
		return (List<Examiner>) examinerRepo.findActiveExaminer();
	}

	@Override
	public Examiner saveOrUpdate(Examiner Examiners) {
		return examinerRepo.save(Examiners);
	}

	@Override
	public void deleteById(long id) {
		examinerRepo.deleteById(id);
	}

	@Override
	public List<Examiner> saveAll(List<Examiner> Examiner) {
		return (List<Examiner>) examinerRepo.saveAll(Examiner);
	}

	@Override
	public int countActive() {
		int count= examinerRepo.activeCount();
		return count;
	}
	

}
