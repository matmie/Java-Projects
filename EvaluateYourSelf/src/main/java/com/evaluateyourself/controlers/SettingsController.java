package com.evaluateyourself.controlers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluateyourself.service.LanguagesControllsService;
import com.evaluateyourself.utils.stuctures.LanguagesControllsSpecificInfo;

@RestController
@RequestMapping(value = "/settings")
public class SettingsController {
	
	@Autowired
	private LanguagesControllsService languagesControllsService;
	
	private Logger logger= LoggerFactory.getLogger(SettingsController.class);
	
	
	@RequestMapping(value = "/language/{parentId}/{language}", method = RequestMethod.GET)
	public Map<String, LanguagesControllsSpecificInfo> changeLanguage(@PathVariable(value="parentId") String parentId, @PathVariable(value="language") String language){
		return this.languagesControllsService.getControllsByParentIdAndLanguage(parentId, language);
	}
	
}
