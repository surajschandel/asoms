package com.lakeacr.asoms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.lakeacr.asoms.domain.Paper;
import com.lakeacr.asoms.domain.User;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface PaperService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Paper getPaper(Long id);

	/**
	 * 
	 * @param paper
	 * @param user
	 * @return
	 */
	String saveOrUpdate(Paper paper, User user);

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
	List<Paper> getPapers();

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
