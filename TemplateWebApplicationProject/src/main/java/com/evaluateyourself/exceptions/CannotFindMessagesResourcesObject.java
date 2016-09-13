/**
 * 
 */
package com.evaluateyourself.exceptions;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 * Exception using, when MessagesResources cannot found.
 */
public class CannotFindMessagesResourcesObject  extends RuntimeException {

	private static final long serialVersionUID = -5019358540763727159L;

	/**
	 * Default constructor for CannotFindMessagesResourcesObject implementation.
	 * @param message Message to print on screen etc.
	 */
	public CannotFindMessagesResourcesObject(String message) {
		super(message);
	}
	
	

}
