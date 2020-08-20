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
import com.lakeacr.asoms.domain.Paper;
import com.lakeacr.asoms.domain.MyUserDetails;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.service.CenterService;
import com.lakeacr.asoms.service.PaperService;

@Controller
public class PaperController {

	
	private static final Logger LOG = LoggerFactory.getLogger(PaperController.class);

	@Autowired
	PaperService centerService;

	@Autowired
	LocationDao locationDao;
	
	@RequestMapping("/paper")
	public String index(Model model) {
		List<Paper> papers = centerService.getPapers();
		model.addAttribute("papers", papers);
		return "paper";
	}

	@RequestMapping("/add-paper")
	public String add(ModelMap model) {
		model.addAttribute("command", new Paper());
		model.addAttribute("locations", locationDao.findAll());
		return "add-paper";
	}

	@RequestMapping("/edit-paper/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		LOG.info("Edit Paper: {}", id);
		try {
			Paper papers = centerService.getPaper(id);
			model.addAttribute("command", papers);
			model.addAttribute("locations", locationDao.findAll());
		} catch (Exception e) {
			LOG.info("Failed to get paper some server error id: {}", id);
		}
		return "add-paper";
	}

	@RequestMapping("/save-paper")
	public String save(@ModelAttribute("command") Paper paper, ModelMap model,
			@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Save Paper: {}", paper);
		try {
			User user = userDetails.getUser();
			model.addAttribute("success", centerService.saveOrUpdate(paper, user));
			model.addAttribute("command", new Paper());
		} catch (Exception e) {
			LOG.error("Some server error: ", e);
			model.addAttribute("error", e.getMessage());
		}
		return "add-paper";
	}

	@RequestMapping("/delete-paper/{id}")
	public String delete(@PathVariable("id") Long id, @AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Delete Paper: {}", id);
		try {
			User user = userDetails.getUser();
			centerService.delete(id, user);
		} catch (Exception e) {
			LOG.info("Failed to delete paper some server error id: {}", id);
		}
		return "paper";
	}

	@RequestMapping("/upload-paper")
	public String upload(@RequestParam("file") MultipartFile file, ModelMap model,
			@AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("upload Paper: {}", file.getOriginalFilename());
		try {
			User user = userDetails.getUser();
			centerService.uploadCsvFileData(file, user.getUserId());
			model.addAttribute("success", "File uploaded successfully");
		} catch (Exception e) {
			LOG.error("Some server error: ", e);
			model.addAttribute("error", "Some error ocurs");
		}
		return "paper";
	}

	@RequestMapping("/export-paper")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		centerService.export(request, response);
	}
}
