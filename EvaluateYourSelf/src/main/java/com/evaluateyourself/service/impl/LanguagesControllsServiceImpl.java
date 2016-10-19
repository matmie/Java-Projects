package com.evaluateyourself.service.impl;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluateyourself.dao.LanguagesControllsDao;
import com.evaluateyourself.service.LanguagesControllsService;
import com.evaluateyourself.utils.stuctures.LanguagesControllsSpecificInfo;

@Service
public class LanguagesControllsServiceImpl implements LanguagesControllsService {

	@Autowired
	private LanguagesControllsDao languagesControllsDao;
	
	@Override
	@Transactional(readOnly=true)
	public Map<String, LanguagesControllsSpecificInfo> getControllsByParentIdAndLanguage(String parentId,
			String language) {
		return this.languagesControllsDao.getControllsByParentIdAndLanguage(parentId, language);
	}

}
