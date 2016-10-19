package com.evaluateyourself.controlers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/settings")
public class SettingsController {
	
	
	private Logger logger= LoggerFactory.getLogger(SettingsController.class);
	

}
