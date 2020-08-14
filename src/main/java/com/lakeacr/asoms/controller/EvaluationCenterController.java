package com.lakeacr.asoms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EvaluationCenterController {

	@RequestMapping("/evaluation-center")
	public String index() {
		return "evaluation-center";
	}
}
