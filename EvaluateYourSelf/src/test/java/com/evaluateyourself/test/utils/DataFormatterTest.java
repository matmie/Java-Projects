package com.evaluateyourself.test.utils;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.evaluateyourself.utils.DataFormatter;



@RunWith(Parameterized.class)
public class DataFormatterTest {
	
	private String inputString;
	
    public DataFormatterTest(String inputString) {
    	this.inputString = inputString;
    }
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] output = {{"plastus0"}, 
				             {"mateuch@1986"}, 
				             {"12__+|||{}{:,./dasdadas"}, 
				             {"MMHGas__*&$&*#@$^*(_)~`1234dsdfsdf"}, 
				             {"\\=+_)(*&^%$#@!~`1234567890-,./<>?;'[]:\"{}"} };  
	   return Arrays.asList(output);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//setup data before all tests in this unit
	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		//clean data after all tests
	}
	
	@Before
	public void setUp() throws Exception {
		//setup data before each test 
	}
	
	@After
	public void setUpAfter() throws Exception {
		//clan data after each test case
	}

	@Test
	public void testDataFormatter() {
		System.out.println("Parametrized string is: " + this.inputString);
		String encodedString = DataFormatter.EncodeStringBase64(this.inputString);
		System.out.println("After Encode: " + encodedString);
		System.out.println("After Decode: " + DataFormatter.DecodeStringBase64(encodedString));
		assertEquals(inputString, DataFormatter.DecodeStringBase64(DataFormatter.EncodeStringBase64(this.inputString)));
	}
	
	@Test
	public void BCryptoTestCase(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
		String encodeString1 = encoder.encode(this.inputString);
		System.out.println("[1]Encoded password for \"" + this.inputString + "\" :" + encodeString1);
		String encodeString2 = encoder.encode(this.inputString);
		System.out.println("[2]Encoded password for \"" + this.inputString + "\" :" + encodeString2);
	}

}
