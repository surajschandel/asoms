package com.lakeacr.asoms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.lakeacr.asoms.domain.Medium;
import com.lakeacr.asoms.domain.User;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface MediumService {

	/**
	 * @param id
	 * @return
	 */
	Medium getMedium(Long id);

	/**
	 * 
	 * @param medium
	 * @param user
	 * @return
	 */
	String saveOrUpdate(Medium medium, User user);

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
	List<Medium> getMedium();

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
