package com.woniu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UrlController {
	//页面跳转
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/addr");
		return mav;
	}
}
