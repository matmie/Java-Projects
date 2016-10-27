/**
 * 
 */
package com.evaluateyourself.utils;

import java.util.Base64;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Mateusz Miernik
 *
 */
public class DataFormatter {
	
	private static Logger logger = LoggerFactory.getLogger(DataFormatter.class);
	
	public static String EncodeStringBase64(String inputString){
		String outputString = "";
		Base64.Encoder encoder = Base64.getEncoder();
		outputString = encoder.encodeToString(inputString.getBytes());
		
		logger.debug("Encoded string \" " + inputString + " \" :" + outputString);
		
		return outputString;
	}
	
	public static String DecodeStringBase64(String inputString){
		String outputString = "";
		Base64.Decoder decoder = Base64.getDecoder();
		outputString = new String(decoder.decode(inputString));
		
		logger.debug("Decoded string \"" + inputString + "\" :" + outputString);
		
		return outputString;
	}
	
	public static String buildRandomString(Integer size){
		char[] chars = "abcdefghijklmnopqrstuvwxwyz1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		for(int i = 0; i<(size-1); i++){
			char c = chars[rand.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String encodePassword(String password){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
		return encoder.encode(password);
	}
}
