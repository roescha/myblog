package myplaces.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import controllers.BlogEntryController;


@RunWith(MockitoJUnitRunner.class)
public class BlogEntryControllerTest {
	
	private BlogEntryController beController;
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		beController = new BlogEntryController();	
		mockMvc = MockMvcBuilders.standaloneSetup(beController).build();
	}
	
	@Test
	public void testGet() throws Exception{
		mockMvc.perform(get("/testGet")).andDo(print());
	}
	
	@Test
	public void testPost() throws Exception{
		String contents = "{\"title\":\"Test blog entry\"}";
		mockMvc.perform(post("/testPost").
		content(contents).
		contentType(MediaType.APPLICATION_JSON)).
		andExpect(jsonPath("$.title", is("Test blog entry"))).
		andDo(print());
	}

}
