package com.lakeacr.asoms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.lakeacr.asoms.domain.Examiner;
import com.lakeacr.asoms.domain.User;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface ExaminerService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Examiner getExaminer(Long id);

	/**
	 * 
	 * @param examiner
	 * @param user
	 * @return
	 */
	String saveOrUpdate(Examiner examiner, User user);

	/**
	 * 
	 * @param id
	 * @param user
	 */
	void delete(Long id, User user);

	/**
	 * 
	 * @return
	 */
	List<Examiner> getExaminer();

	/**
	 * 
	 * @param file
	 * @param userId
	 * @return
	 */
	String uploadCsvFileData(MultipartFile file, Long userId);

	/**
	 * 
	 * @param request
	 * @param response
	 */
	void export(HttpServletRequest request, HttpServletResponse response);
}
