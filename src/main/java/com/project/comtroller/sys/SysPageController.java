package com.project.comtroller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysPageController {

	@RequestMapping("/{url}.html")
	public String page(@PathVariable("url") String url){
		return url;
	}
	
}
