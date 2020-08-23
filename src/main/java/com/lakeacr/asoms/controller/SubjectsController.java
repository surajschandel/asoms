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

import com.lakeacr.asoms.domain.MyUserDetails;
import com.lakeacr.asoms.domain.Subjects;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.service.SubjectsService;

@Controller
public class SubjectsController {

	private static final Logger LOG = LoggerFactory.getLogger(SubjectsController.class);
	
	@Autowired
	SubjectsService subjectsService;

	@RequestMapping("/subjects")
	public String index(Model model) {
		List<Subjects> subjects= subjectsService.getSubjects();
		model.addAttribute("subjects",subjects);
		return "subjects";
	}

	@RequestMapping("/add-subject")
	public String addSubject(ModelMap model) {
		model.addAttribute("command", new Subjects());
		return "add-subject";
	}

	@RequestMapping("/edit-subject/{id}")
	public String editSubject(@PathVariable("id") Long id, ModelMap model) {
		LOG.info("Edit Subject: {}" , id);
		try {
			Subjects subjects=subjectsService.getSubject(id);
			model.addAttribute("command", subjects);
		} catch (Exception e) {
			LOG.info("Failed to get subject some server error Subject id: {}" , id);
		}
		return "add-subject";
	}
	@RequestMapping("/save-subject")
	public String saveSubject(@ModelAttribute("command") Subjects subjects, ModelMap model,@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Save Subject: {}" , subjects);
		try {
			User user=userDetails.getUser();
			model.addAttribute("success", subjectsService.saveOrUpdateSubject(subjects,user));
			model.addAttribute("command", new Subjects());
		} catch (Exception e) {
			LOG.error("Some server error: " , e);
			model.addAttribute("error", e.getMessage());
		}
		return "add-subject";
	}
	@RequestMapping("/delete-subject/{id}")
	public String deleteSubject(@PathVariable("id") Long id,@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Delete Subject: {}" , id);
		try {
			User user=userDetails.getUser();
			subjectsService.deleteSubject(id,user);
		} catch (Exception e) {
			LOG.info("Failed to delete subject some server error Subject id: {}" , id);
		}
		return "subjects";
	}
	
	@RequestMapping("/upload-subject")
	public String uploadSubject(@RequestParam("file") MultipartFile file,ModelMap model, @AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("upload Subject: {}" , file.getName());
		try {
			User user=userDetails.getUser();
			subjectsService.uploadCsvFileData(file, user.getUserId());
			model.addAttribute("success", "File uploaded successfully");
		} catch (Exception e) {
			LOG.error("Some server error: " , e);
			model.addAttribute("error", "Some error ocurs");
		}
		return "subjects";
	}
	@RequestMapping("/export-subjects")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		subjectsService.export(request, response);
	}
}
