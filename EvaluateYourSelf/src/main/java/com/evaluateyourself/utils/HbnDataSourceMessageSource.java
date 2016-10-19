package com.evaluateyourself.utils;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;

import com.evaluateyourself.service.MessagesResourcesManager;


/**
 * MessageSource implementation that reads the messages from hibernate database
 */
public class HbnDataSourceMessageSource extends AbstractMessageSource implements InitializingBean
{
	
	@Autowired
	MessagesResourcesManager messagesManager;

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		
		/**
		 * TODO: Delete this in the future. Only for testing
		 */
		locale = new Locale("pl","PL");
		String message = messagesManager.getMessageForLocale(code, locale);
		MessageFormat mf = new MessageFormat(message, locale);
		return mf;
	}
	
}

