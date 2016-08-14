/**
 * 
 */
package com.evaluateyourself.webstore.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Date;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public class Utils {
	
	public static BigDecimal convertFromString(String decimalString){
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);
		
		BigDecimal bigDecimal = null;
		try {
			bigDecimal = (BigDecimal) decimalFormat.parse(decimalString);
		} catch (ParseException e) {
			System.out.println(new Date() + ": Error during parse String format to decimal format");
			e.printStackTrace();
		}
		return bigDecimal;
	}
}
