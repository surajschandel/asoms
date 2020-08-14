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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lakeacr.asoms.domain.MyUserDetails;
import com.lakeacr.asoms.domain.Locations;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.service.LocationService;
@Controller
public class ScanningLocationController {

private static final Logger LOG = LoggerFactory.getLogger(ScanningLocationController.class);
	
	@Autowired
	LocationService locationService;

	@RequestMapping("/assl")
	public String location(Model model) {
		List<Locations> location= locationService.getLocations();
		model.addAttribute("locations",location);
		return "scanning-location";
	}

	@RequestMapping("/add-location")
	public String addLocation(ModelMap model) {
		model.addAttribute("command", new Locations());
		return "add-location";
	}

	@RequestMapping("/edit-location/{id}")
	public String editLocation(@PathVariable("id") Long id, ModelMap model) {
		LOG.info("Edit Location: {}" , id);
		try {
			Locations location=locationService.getLocation(id);
			model.addAttribute("command", location);
		} catch (Exception e) {
			LOG.info("Failed to get location some server error Location id: {}" , id);
		}
		return "add-location";
	}
	@RequestMapping("/save-location")
	public String saveLocation(@ModelAttribute("command") Locations location, ModelMap model, @AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Save Location: {}" , location);
		try {
			User user=userDetails.getUser();
			model.addAttribute("success", locationService.saveOrUpdateLocation(location,user));
			model.addAttribute("command", new Locations());
		} catch (Exception e) {
			LOG.error("Some server error: " , e);
			model.addAttribute("error", e.getMessage());
		}
		return "add-location";
	}
	@RequestMapping("/delete-location/{id}")
	public String deleteLocation(@PathVariable("id") Long id, @AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("Delete Location: {}" , id);
		try {
			User user=userDetails.getUser();
			locationService.deleteLocation(id, user);
		} catch (Exception e) {
			LOG.info("Failed to delete location some server error Location id: {}" , id);
		}
		return "scanning-location";
	}
	
	@RequestMapping("/upload-location")
	@ResponseBody
	public void uploadLocation(@RequestParam("file") MultipartFile file,ModelMap model, @AuthenticationPrincipal MyUserDetails userDetails) {
		LOG.info("upload Scanning locations: {}" , file.getOriginalFilename());
		try {
			User user=userDetails.getUser();
			locationService.uploadCsvFileData(file,user.getUserId());
			model.addAttribute("success", "File uploaded successfully");
		} catch (Exception e) {
			LOG.error("Some server error: " , e);
			model.addAttribute("error", "Some error ocurs");
		}
	}
	@RequestMapping("/export-locations")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		locationService.export(request, response);
	}
}
