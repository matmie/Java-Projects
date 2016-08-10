/**
 * 
 */
package com.evaluateyourself.main;

import java.util.Date;

import com.evaluateyourself.model.Users;
import com.evaluateyourself.service.UsersManager;
import com.evaluateyourself.service.UsersManagerImpl;

/**
 * @author Mateusz
 *
 */
public class MainClass {
    
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UsersManager manager = new UsersManagerImpl();
		Users usr;
		for(int i = 0; i<100; i++){
			//usr = new Users("aaa" + Integer.toString(i), "aaa" + Integer.toString(i), new Date(), new Date(), "aaa" + Integer.toString(i), "aaa" + Integer.toString(i), "aaa" + Integer.toString(i));
			//manager.addUser(usr);
		}
		
	}

}
