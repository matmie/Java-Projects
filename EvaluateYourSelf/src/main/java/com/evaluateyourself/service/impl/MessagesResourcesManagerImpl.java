/**
 * 
 */
package com.evaluateyourself.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluateyourself.dao.MessagesResourcesDao;
import com.evaluateyourself.model.MessagesResources;
import com.evaluateyourself.service.MessagesResourcesManager;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Service
public class MessagesResourcesManagerImpl implements MessagesResourcesManager {
    
	@Autowired
	MessagesResourcesDao messagesDao;

	
	@Override
	public String getMessageForLocale(String code, Locale locale) {
		MessagesResources mr = messagesDao.getMessageForLocale(code, locale);
		String localeIso3Language = locale.getISO3Language();
		String firstCharacterlocale = localeIso3Language.substring(0,1);
		firstCharacterlocale = firstCharacterlocale.toUpperCase();
		String methodName = "get"+firstCharacterlocale + localeIso3Language.substring(1,localeIso3Language.length());
		Method method = null;
		try {
			method = MessagesResources.class.getMethod(methodName, new Class<?>[]{});
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		if(method == null){
			throw new NullPointerException("Cannot find '" + methodName + "' method in MessagesResources class.");
		}
		String message = null;
		try {
			message = (String) method.invoke(mr);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		if(message == null) {
			throw new NullPointerException("Cannot get message from MessagesResources object using reflections for '" + methodName + "' method");
		}
		return message;
	}

}
