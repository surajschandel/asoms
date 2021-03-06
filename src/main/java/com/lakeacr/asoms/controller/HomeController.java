package com.lakeacr.asoms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lakeacr.asoms.service.DashBoardService;

@Controller
public class HomeController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	DashBoardService dashBoardService;
	
	@RequestMapping({"/","/index"})
	public String index(Model model) {
		try {
			model.addAttribute("counts", dashBoardService.dashboardCount());	
		} catch (Exception e) {
			LOG.error("Some error to get dashboard count: ",e);
		}
		return "index";
	}
}
