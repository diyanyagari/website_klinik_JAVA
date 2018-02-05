package com.xsis.bootcamp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value="/")
	public String home(){
		return "index";
	}
	//coba
}
