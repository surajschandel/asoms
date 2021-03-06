package com.lakeacr.asoms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lakeacr.asoms.dao.CenterDao;
import com.lakeacr.asoms.dao.LocationDao;
import com.lakeacr.asoms.domain.HeadExaminer;
import com.lakeacr.asoms.domain.MyUserDetails;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.service.HeadExaminerService;

@Controller
public class HeadExaminerController {

	private static final Logger LOG = LoggerFactory.getLogger(HeadExaminerController.class);
	@Autowired
	HeadExaminerService headExaminerService;
	
	@Autowired
	LocationDao locationDao;

	@Autowired
	CenterDao centerDao;
		
	@RequestMapping("/head-examiner")
	public String index(Model model) {
		List<HeadExaminer> headExaminers = headExaminerService.getHeadExaminer();
		model.addAttribute("headExaminers", headExaminers);
		return "head-examiner";
	}

	@RequestMapping("/add-head-examiner")
	public String add(ModelMap model) {
		model.addAttribute("command", new HeadExaminer());
		model.addAttribute("locations", locationDao.findAll());
		model.addAttribute("centers", centerDao.findAll());
		return "add-head-examiner";
	}

	@RequestMapping("/edit-head-examiner/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		LOG.info("Edit Center: {}", id);
		try {
			HeadExaminer headExaminers = headExaminerService.getHeadExaminer(id);
			model.addAttribute("command", headExaminers);
			model.addAttribute("locations", locationDao.findAll());
			model.addAttribute("centers", centerDao.findAll());
		} catch (Exception e) {
			LOG.info("Failed to get head examiner some server error id: {}", id);
		}
		return "add-head-examiner";
	}

	@RequestMapping("/save-head-examiner")
	public String save(@ModelAttribute("command") HeadExaminer center, ModelMap model,
			@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Save Head Examiner: {}", center);
		try {
			User user = userDetails.getUser();
			model.addAttribute("success", headExaminerService.saveOrUpdate(center, user));
			model.addAttribute("command", new HeadExaminer());
		} catch (Exception e) {
			LOG.error("Some server error: ", e);
			model.addAttribute("error", e.getMessage());
		}
		return "add-head-examiner";
	}

	@RequestMapping("/delete-head-examiner/{id}")
	public String delete(@PathVariable("id") Long id, @AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Delete Head Examiner: {}", id);
		try {
			User user = userDetails.getUser();
			headExaminerService.delete(id, user);
		} catch (Exception e) {
			LOG.info("Failed to delete head examiner some server error id: {}", id);
		}
		return "head-examiner";
	}

	@RequestMapping("/upload-head-examiner")
	public String upload(@RequestParam("file") MultipartFile file, ModelMap model,
			@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("upload head examiner: {}", file.getOriginalFilename());
		try {
			User user = userDetails.getUser();
			headExaminerService.uploadCsvFileData(file, user.getUserId());
			model.addAttribute("success", "File uploaded successfully");
		} catch (Exception e) {
			LOG.error("Some server error: ", e);
			model.addAttribute("error", "Some error ocurs");
		}
		return "head-examiner";
	}

	@RequestMapping("/export-head-examiner")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		headExaminerService.export(request, response);
	}

 }
