/**
 * 
 */
package com.madmatsoft.restapp.restcontroller.choirmember.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.madmatsoft.restapp.model.ChoirMember;

/**
 * @author Mateusz Miernik
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class ChoirMemberRestController {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockHttpSession session;
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testGetAllChoirMembers() throws Exception {
		this.mockMvc.perform(get("/membersList/getAll").session(session)).andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$.[0].choirMemberId").value(4));
	}

	@Test
	public void testCreateNewChoirMember() throws Exception {
		ChoirMember chmem = new ChoirMember("Mateusz", "111");
		ObjectMapper om = new ObjectMapper();
		String chMemAsJson = om.writeValueAsString(chmem);
		
		this.mockMvc.perform(post("/membersList/add").session(session).contentType(MediaType.APPLICATION_JSON).content(chMemAsJson)).andExpect(status().isOk());
	}

	@Test
	public void testUpdateChoirMember() throws Exception {
		ChoirMember chmem = new ChoirMember("Mateusz", "111");
		chmem.setChoirMemberId(2000);
		ObjectMapper om = new ObjectMapper();
		String chMemAsJson = om.writeValueAsString(chmem);
		
		this.mockMvc.perform(put("/membersList/update/" + 3).contentType(MediaType.APPLICATION_JSON).content(chMemAsJson).session(session)).andExpect(status().is(204));
	}

	@Test
	public void deleteChoirMember() throws Exception {
		this.mockMvc.perform(put("/membersList/delete/" + 5).session(session)).andExpect(status().is(204));
	}

	public void updateChoirMemberWithExistingId() throws Exception {
		ChoirMember chmem = new ChoirMember("Mateusz", "111");
		chmem.setChoirMemberId(7);
		ObjectMapper om = new ObjectMapper();
		String chMemAsJson = om.writeValueAsString(chmem);
		
		this.mockMvc.perform(put("/membersList/update/" + 2).contentType(MediaType.APPLICATION_JSON).content(chMemAsJson).session(session)).andExpect(status().is(500));
	}

}
