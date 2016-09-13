/**
 * 
 */
package com.evaluateyourself.dao;

import java.util.Locale;

import com.evaluateyourself.model.MessagesResources;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com] Interface defines
 *         methods for messages from messsagesresources table, which is mapped
 *         to {@link com.evaluateyourself.model.MessagesResources
 *         MessagesResources} objects.
 */
public interface MessagesResourcesDao {
	/**
	 * Methods searching value from messagesresources data table.  
	 * @param code This parameter represents messagesresources.mrcode value.
	 * @param locale This parameter using to describe Exceptions etc.
	 * @return MessagesResources one object represents one messages for all locales.
	 */
	public MessagesResources getMessageForLocale(String code, Locale locale);
}
