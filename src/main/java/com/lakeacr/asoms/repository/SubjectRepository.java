package com.lakeacr.asoms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lakeacr.asoms.domain.Subjects;

public interface SubjectRepository extends CrudRepository<Subjects, Long>  {

	Subjects findBySubjectCode(String subjectCode);
	

	@Query("SELECT l FROM Subjects l WHERE l.isDeleted = 0")
	List<Subjects> findActiveSubjects();
	
	@Query("SELECT COUNT(l) FROM Subjects l WHERE l.isDeleted = 0")
	int activeCount();
	
	
}
