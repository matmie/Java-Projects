package com.evaluateyourself.service;

import java.util.Map;

import com.evaluateyourself.utils.stuctures.LanguagesControllsSpecificInfo;

public interface LanguagesControllsService {
	Map<String,LanguagesControllsSpecificInfo> getControllsByParentIdAndLanguage(String parentId, String language);
}
