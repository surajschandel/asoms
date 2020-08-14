package com.lakeacr.asoms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeadExaminerController {

	@RequestMapping("/head-examiner")
	public String index() {
		return "head-examiner";
	}
}
