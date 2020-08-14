/**
 * 
 */
package com.lakeacr.asoms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakeacr.asoms.domain.Subjects;
import com.lakeacr.asoms.repository.SubjectRepository;

/**
 * @author SURAJ CHANDEL
 *
 */
@Repository
public class SubjectsDaoImpl implements SubjectsDao {

	@Autowired
	SubjectRepository subjectsRepo;
	
	@Override
	public Subjects findById(long id) {
		// TODO Auto-generated method stub
		Optional<Subjects> subject=subjectsRepo.findById(id);
		return subject.get() ;
	}

	@Override
	public Subjects findBySubjectCode(String subjectCode) {
		return subjectsRepo.findBySubjectCode(subjectCode) ;
	}

	@Override
	public List<Subjects> findAll() {
		return (List<Subjects>) subjectsRepo.findActiveSubjects();
	}

	@Override
	public Subjects saveOrUpdate(Subjects subjects) {
		return subjectsRepo.save(subjects);
	}

	@Override
	public List<Subjects> saveAll(List<Subjects> subjects) {
		return (List<Subjects>) subjectsRepo.saveAll(subjects);
	}

	@Override
	public int countActive() {
		int count= subjectsRepo.activeCount();
		return count;
	}

	

}
