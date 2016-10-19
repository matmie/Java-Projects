package com.evaluateyourself.dao;

import java.util.Map;

import com.evaluateyourself.utils.stuctures.LanguagesControllsSpecificInfo;

public interface LanguagesControllsDao {
	 Map<String,LanguagesControllsSpecificInfo> getControllsByParentIdAndLanguage(String parentId, String language);
}
