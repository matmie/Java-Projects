/**
 * 
 */
package com.madmatsoft.store3d.service;

import java.util.Locale;

import com.madmatsoft.store3d.model.MessagesResources;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com] Interface for
 *         {@link com.madmatsoft.store3d.model.MessagesResources
 *         MessagesResources} service implementations.
 */
public interface MessagesResourcesManager {
	/**
	 * Method for search {@link com.madmatsoft.store3d.model.MessagesResources
	 * MessagesResources} object in database. When the MessagesResources object
	 * has been return, method use Java Reflections API for invoke method from
	 * this object. This method returns only one column(represents by locale.getIso3Language()).
	 * 
	 * @param code
	 *            This parameter represents messagesresources.mrcode value.
	 * @param locale
	 *            This parameter using to describe object method. This method
	 *            uses Java Reflections for invoke method from
	 *            {@link com.madmatsoft.store3d.model.MessagesResources
	 *            MessagesResources} object.
	 * @return Only one field from
	 *         {@link com.madmatsoft.store3d.model.MessagesResources
	 *         MessagesResources} object using Reflections API.
	 */
	public String getMessageForLocale(String code, Locale locale);
}
