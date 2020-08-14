package com.lakeacr.asoms.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.service.UserService;

@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public String index() {
		return "login";
	}
	
	/*
	 * @CrossOrigin
	 * 
	 * @RequestMapping(value = "/login", method = RequestMethod.POST, produces =
	 * "text/html") public String login(@RequestBody User user, HttpSession
	 * httpSession) { LOG.info(" login for user {}", user.getUserName()); String
	 * success=""; try { User userExists =
	 * userService.userExists(user.getUserName(), user.getPassword()); if
	 * (userExists!=null) { success="Successfully login"; }else {
	 * 
	 * success="Failed to login"; } } catch (Exception e) { e.printStackTrace();
	 * LOG.error("Some error login for user {}", user.getUserName());
	 * 
	 * success="Some server error in login"; } System.out.println("Msg: "+success);
	 * return success; }
	 */
}
