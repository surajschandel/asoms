package com.lakeacr.asoms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.lakeacr.asoms.domain.Locations;
import com.lakeacr.asoms.domain.User;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface LocationService {

	/**
	 * 
	 * @return
	 */
	Locations getLocation(Long id);

	/**
	 * 
	 * @param location
	 * @return
	 */
	String saveOrUpdateLocation(Locations location, User user);

	/**
	 * 
	 * @return
	 */
	void deleteLocation(Long id, User user);

	/**
	 * 
	 * @return
	 */
	List<Locations> getLocations();

	/**
	 * 
	 * @param file
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
