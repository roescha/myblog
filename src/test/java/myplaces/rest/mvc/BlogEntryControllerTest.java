package myplaces.rest.mvc;

import static org.mockito.Mockito.*;  
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.endsWith;
import myblog.core.models.entities.BlogEntry;
import myblog.core.services.BlogEntryService;
import myblog.rest.mvc.BlogEntryController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(MockitoJUnitRunner.class)
public class BlogEntryControllerTest {
	
	private BlogEntryController beController;
	
	@Mock
	private BlogEntryService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		beController = new BlogEntryController(service);	
		mockMvc = MockMvcBuilders.standaloneSetup(beController).build();
	}
	
	@Test
	public void  getExistingBlogEntry() throws Exception{
		BlogEntry entry = new BlogEntry();
		entry.setId(1L);
		entry.setTitle("Test Title");
		when(service.findBlogEntry(1L)).thenReturn(entry);
		mockMvc.perform(get("/rest/blog-entries/1"))
		.andDo(print())
		.andExpect(jsonPath("$.title", is(entry.getTitle())))
		.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
		.andExpect(status().isOk());
	}
	
	@Test
	public void  getNonExistingBlogEntry() throws Exception{
		when(service.findBlogEntry(1L)).thenReturn(null);
		mockMvc.perform(get("/rest/blog-entries/1"))
		.andExpect(status().isNotFound());
		
	}
	
	
}
