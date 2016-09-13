/**
 * 
 */
package com.evaluateyourself.webstore.validator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

import com.evaluateyourself.webstore.domain.Product;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class ProductValidatorTest {
	
	Logger logger = Logger.getLogger(ProductValidatorTest.class);
	@Autowired
	private ProductValidator productValidator;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void product_without_UnitPrice_should_be_invalid() {
		//Set
		Product product = new Product();
		BindException bindException = new BindException(product,"product");
		//Execute
		ValidationUtils.invokeValidator(productValidator, product, bindException);
		for(ObjectError oerr:bindException.getAllErrors()){
			logger.debug(oerr.getDefaultMessage());
		}
		
		//Compare
		Assert.assertEquals(3, bindException.getErrorCount());
		
		Assert.assertTrue(bindException.getLocalizedMessage().contains("Błędna cena produktu. Cena nie może byc pusta"));
		
	}
	@Test
	public void product_with_existing_productId_invalid(){
		//Set
		Product product = new Product("P1234","iphone 5s",new BigDecimal(500));
		product.setCategory("Tablet");
		
		BindException bindException = new BindException(product,"product");
		//Execute
		ValidationUtils.invokeValidator(productValidator, product, bindException);
		
		//Compare
		
		for(ObjectError oerr:bindException.getAllErrors()){
			logger.debug(oerr.getDefaultMessage());
		}
		Assert.assertEquals(1, bindException.getErrorCount());
		Assert.assertTrue(bindException.getLocalizedMessage().contains("Produkt o wskazanym identyfikatorze już istnieje"));
	}
	
	@Test
	public void a_valid_product_should_not_get_any_error_during_validation(){
		//Set
		Product product = new Product("P9876","iphone 5s",new BigDecimal(500));
		product.setCategory("Tablet");
		
		BindException bindException = new BindException(product,"product");
		
		//Execute
		ValidationUtils.invokeValidator(productValidator, product, bindException);
		
		//Compare
		for(ObjectError oerr:bindException.getAllErrors()){
			logger.debug(oerr.getDefaultMessage());
		}
		Assert.assertEquals(0, bindException.getErrorCount());
		
		
	}

}
