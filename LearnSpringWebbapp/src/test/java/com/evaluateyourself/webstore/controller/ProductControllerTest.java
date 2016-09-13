/**
 * 
 */
package com.evaluateyourself.webstore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.evaluateyourself.webstore.domain.Product;
import com.evaluateyourself.webstore.service.ProductService;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class ProductControllerTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private ProductService productService;
	private MockMvc mockMvc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testGetProducts() throws Exception {
		//Http response, request simulation object
		this.mockMvc.perform(get("/products")).andExpect(model().attributeExists("products"));
	}

	@Test
	public void testGetProductById() throws Exception {
		// Set
		Product product = productService.getProductById("P1234");
		// Execute and Comparet
		this.mockMvc.perform(get("/products/product").param("id", "P1234"))
				.andExpect(model().attributeExists("product")).andExpect(model().attribute("product", product));
	}

}
