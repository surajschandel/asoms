package com.lakeacr.asoms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MediumController {

	@RequestMapping("/medium")
	public String index() {
		return "medium";
	}
}
