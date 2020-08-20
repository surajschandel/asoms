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
import com.lakeacr.asoms.dao.HeadExaminerDao;
import com.lakeacr.asoms.dao.SubjectsDao;
import com.lakeacr.asoms.domain.Examiner;
import com.lakeacr.asoms.domain.MyUserDetails;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.service.ExaminerService;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
@Controller
public class ExaminerController {

	private static final Logger LOG = LoggerFactory.getLogger(ExaminerController.class);
	@Autowired
	ExaminerService examinerService;
	
	@Autowired
	SubjectsDao subjectsDao;

	@Autowired
	HeadExaminerDao headExaminerDao;
	
	@Autowired
	CenterDao centerDao;
		
	@RequestMapping("/examiner")
	public String index(Model model) {
		List<Examiner> headExaminers = examinerService.getExaminer();
		model.addAttribute("examiners", headExaminers);
		return "examiner";
	}

	@RequestMapping("/add-examiner")
	public String add(ModelMap model) {
		model.addAttribute("command", new Examiner());
		model.addAttribute("subjects", subjectsDao.findAll());
		model.addAttribute("centers", centerDao.findAll());
		model.addAttribute("headExaminers", headExaminerDao.findAll());
		return "add-examiner";
	}

	@RequestMapping("/edit-examiner/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		LOG.info("Edit Examiner: {}", id);
		try {
			Examiner examiner = examinerService.getExaminer(id);
			model.addAttribute("command", examiner);
			model.addAttribute("subjects", subjectsDao.findAll());
			model.addAttribute("centers", centerDao.findAll());
			model.addAttribute("headExaminers", headExaminerDao.findAll());
		} catch (Exception e) {
			LOG.info("Failed to get examiner some server error id: {}", id);
		}
		return "add-examiner";
	}

	@RequestMapping("/save-examiner")
	public String save(@ModelAttribute("command") Examiner center, ModelMap model,
			@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Save Examiner: {}", center);
		try {
			User user = userDetails.getUser();
			model.addAttribute("success", examinerService.saveOrUpdate(center, user));
			model.addAttribute("command", new Examiner());
		} catch (Exception e) {
			LOG.error("Some server error: ", e);
			model.addAttribute("error", e.getMessage());
		}
		return "add-examiner";
	}

	@RequestMapping("/delete-examiner/{id}")
	public String delete(@PathVariable("id") Long id, @AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Delete Examiner: {}", id);
		try {
			User user = userDetails.getUser();
			examinerService.delete(id, user);
		} catch (Exception e) {
			LOG.info("Failed to delete head examiner some server error id: {}", id);
		}
		return "examiner";
	}

	@RequestMapping("/upload-examiner")
	public String upload(@RequestParam("file") MultipartFile file, ModelMap model,
			@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("upload examiner: {}", file.getOriginalFilename());
		try {
			User user = userDetails.getUser();
			examinerService.uploadCsvFileData(file, user.getUserId());
			model.addAttribute("success", "File uploaded successfully");
		} catch (Exception e) {
			LOG.error("Some server error: ", e);
			model.addAttribute("error", "Some error ocurs");
		}
		return "examiner";
	}

	@RequestMapping("/export-examiner")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		examinerService.export(request, response);
	}

}
