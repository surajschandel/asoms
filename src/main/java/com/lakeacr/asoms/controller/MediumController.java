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

import com.lakeacr.asoms.domain.Medium;
import com.lakeacr.asoms.domain.MyUserDetails;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.service.MediumService;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
@Controller
public class MediumController {

	private static final Logger LOG = LoggerFactory.getLogger(MediumController.class);

	@Autowired
	MediumService mediumService;

	@RequestMapping("/medium")
	public String index(Model model) {
		List<Medium> mediums = mediumService.getMedium();
		model.addAttribute("mediums", mediums);
		return "medium";
	}

	@RequestMapping("/add-medium")
	public String add(ModelMap model) {
		model.addAttribute("command", new Medium());
		return "add-medium";
	}

	@RequestMapping("/edit-medium/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		LOG.info("Edit Medium: {}", id);
		try {
			Medium mediums = mediumService.getMedium(id);
			model.addAttribute("command", mediums);
		} catch (Exception e) {
			LOG.info("Failed to get medium some server error id: {}", id);
		}
		return "add-medium";
	}

	@RequestMapping("/save-medium")
	public String save(@ModelAttribute("command") Medium medium, ModelMap model,
			@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Save Medium: {}", medium);
		try {
			User user = userDetails.getUser();
			model.addAttribute("success", mediumService.saveOrUpdate(medium, user));
			model.addAttribute("command", new Medium());
		} catch (Exception e) {
			LOG.error("Some server error: ", e);
			model.addAttribute("error", e.getMessage());
		}
		return "add-medium";
	}

	@RequestMapping("/delete-medium/{id}")
	public String delete(@PathVariable("id") Long id, @AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Delete Medium: {}", id);
		try {
			User user = userDetails.getUser();
			mediumService.delete(id, user);
		} catch (Exception e) {
			LOG.info("Failed to delete medium some server error id: {}", id);
		}
		return "medium";
	}

	@RequestMapping("/upload-medium")
	public String upload(@RequestParam("file") MultipartFile file, ModelMap model,
			@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("upload Medium: {}", file.getName());
		try {
			User user = userDetails.getUser();
			mediumService.uploadCsvFileData(file, user.getUserId());
			model.addAttribute("success", "File uploaded successfully");
		} catch (Exception e) {
			LOG.error("Some server error: ", e);
			model.addAttribute("error", "Some error ocurs");
		}
		return "mediums";
	}

	@RequestMapping("/export-medium")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		mediumService.export(request, response);
	}
}
