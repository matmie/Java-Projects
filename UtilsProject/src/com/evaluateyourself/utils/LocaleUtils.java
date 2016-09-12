package com.evaluateyourself.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 * Extra methods for Locale class.
 */
public class LocaleUtils {
	
	/**
	 * Method check if locale exist in classes using locales like NumberFormat, DateFormat etc.
	 * @param loc Locale for checking in other class. 
	 * @param clas Class contains getAvailableLocales for searching.
	 * @return True if locale exist, false otherwise.
	 */
	public static boolean checkLocaleExistInClass(Locale loc, Class<?> clas){
		Locale[] locales = null;
		try {
			locales = (Locale[]) clas.getMethod("getAvailableLocales", new Class[]{}).invoke(clas);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		for(Locale loca:locales){
			if(loca.equals(loc)){
				System.out.println("There is locale " + loc.getLanguage() + "_" + loc.getCountry() + " on " + clas.getSimpleName() + " class.");
				return true;
			}
		}
		System.err.println("Cannot found "+ loc.getLanguage() + "_" + loc.getCountry() + "on " +  clas.getSimpleName() + " class.");
		return false;
	}
}

