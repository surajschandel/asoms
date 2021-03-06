package com.lakeacr.asoms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.lakeacr.asoms.domain.Subjects;
import com.lakeacr.asoms.domain.User;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface SubjectsService {

	/**
	 * 
	 * @return
	 */
	Subjects getSubject(Long id);
	/**
	 * 
	 * @param subject
	 * @return
	 */
	String saveOrUpdateSubject(Subjects subject, User user);

	/**
	 * 
	 * @return
	 */
	void deleteSubject(Long id, User user);

	/**
	 * 
	 * @return
	 */
	List<Subjects> getSubjects();
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	String uploadCsvFileData(MultipartFile file, Long userId) ;
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	void export(HttpServletRequest request, HttpServletResponse response);

}
