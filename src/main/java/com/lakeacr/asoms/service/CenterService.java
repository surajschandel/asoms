package com.lakeacr.asoms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.lakeacr.asoms.domain.Centers;
import com.lakeacr.asoms.domain.User;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface CenterService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Centers getCenter(Long id);

	/**
	 * 
	 * @param centers
	 * @param user
	 * @return
	 */
	String saveOrUpdate(Centers centers, User user);

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
	List<Centers> getCenters();

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
