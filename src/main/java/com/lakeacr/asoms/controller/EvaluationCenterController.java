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

import com.lakeacr.asoms.dao.LocationDao;
import com.lakeacr.asoms.domain.Centers;
import com.lakeacr.asoms.domain.MyUserDetails;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.service.CenterService;

@Controller
public class EvaluationCenterController {

	
	private static final Logger LOG = LoggerFactory.getLogger(EvaluationCenterController.class);

	@Autowired
	CenterService centerService;

	@Autowired
	LocationDao locationDao;
	
	@RequestMapping("/evaluation-center")
	public String index(Model model) {
		List<Centers> centers = centerService.getCenters();
		model.addAttribute("centers", centers);
		return "evaluation-center";
	}

	@RequestMapping("/add-center")
	public String add(ModelMap model) {
		model.addAttribute("command", new Centers());
		model.addAttribute("locations", locationDao.findAll());
		return "add-center";
	}

	@RequestMapping("/edit-center/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		LOG.info("Edit Center: {}", id);
		try {
			Centers centers = centerService.getCenter(id);
			model.addAttribute("command", centers);
			model.addAttribute("locations", locationDao.findAll());
		} catch (Exception e) {
			LOG.info("Failed to get center some server error id: {}", id);
		}
		return "add-center";
	}

	@RequestMapping("/save-center")
	public String save(@ModelAttribute("command") Centers center, ModelMap model,
			@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Save Center: {}", center);
		try {
			User user = userDetails.getUser();
			model.addAttribute("success", centerService.saveOrUpdate(center, user));
			model.addAttribute("command", new Centers());
		} catch (Exception e) {
			LOG.error("Some server error: ", e);
			model.addAttribute("error", e.getMessage());
		}
		return "add-center";
	}

	@RequestMapping("/delete-center/{id}")
	public String delete(@PathVariable("id") Long id, @AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Delete Center: {}", id);
		try {
			User user = userDetails.getUser();
			centerService.delete(id, user);
		} catch (Exception e) {
			LOG.info("Failed to delete center some server error id: {}", id);
		}
		return "center";
	}

	@RequestMapping("/upload-center")
	public String upload(@RequestParam("file") MultipartFile file, ModelMap model,
			@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("upload Center: {}", file.getOriginalFilename());
		try {
			User user = userDetails.getUser();
			centerService.uploadCsvFileData(file, user.getUserId());
			model.addAttribute("success", "File uploaded successfully");
		} catch (Exception e) {
			LOG.error("Some server error: ", e);
			model.addAttribute("error", "Some error ocurs");
		}
		return "centers";
	}

	@RequestMapping("/export-center")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		centerService.export(request, response);
	}
}
