/**
 * 
 */
package com.evaluateyourself.webstore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.evaluateyourself.webstore.service.ProductService;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class CartRestControllerTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private ProductService productService;
	private MockMvc mockMvc;
	@Autowired
	MockHttpSession session;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Http response, request simulation object
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void read_method_should_return_correct_Json_object() throws Exception {
		// Set
		this.mockMvc.perform(put("/rest/cart/add/P1234").session(session)).andExpect(status().is(204));
		// Execute
		this.mockMvc.perform(get("/rest/cart/" + session.getId()).session(session)).andExpect(status().isOk())
				.andExpect(jsonPath("$.cartItems.P1234.product.productId").value("P1234"));
	}
}
