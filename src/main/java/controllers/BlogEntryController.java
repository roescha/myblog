package controllers;

import myplaces.entities.BlogEntry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BlogEntryController {
	
	@RequestMapping("/testGet")
	public @ResponseBody BlogEntry testGet(){
		
		BlogEntry entry = new BlogEntry();
		entry.setTitle("Test blog entry");
		return entry;
	}
	

	@RequestMapping(value = "/testPost", method=RequestMethod.POST)
	public @ResponseBody BlogEntry testPost(@RequestBody  BlogEntry entry){
		return entry;
	}

}
