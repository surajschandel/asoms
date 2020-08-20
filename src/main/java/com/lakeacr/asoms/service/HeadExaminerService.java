package com.lakeacr.asoms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.lakeacr.asoms.domain.HeadExaminer;
import com.lakeacr.asoms.domain.User;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface HeadExaminerService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	HeadExaminer getHeadExaminer(Long id);

	/**
	 * 
	 * @param headExaminer
	 * @param user
	 * @return
	 */
	String saveOrUpdate(HeadExaminer headExaminer, User user);

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
	List<HeadExaminer> getHeadExaminer();

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
