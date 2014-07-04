package myplaces.rest.mvc;

import myplaces.core.entities.BlogEntry;
import myplaces.core.services.BlogEntryService;
import myplaces.rest.resources.BlogEntryResource;
import myplaces.rest.resources.asm.BlogEntryResourceAssembler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {

	private BlogEntryService service;

	public BlogEntryController(BlogEntryService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{blogEntryId}", method = RequestMethod.GET)
	public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long blogEntryId) {
		BlogEntry entry = service.find(blogEntryId);
		if (entry != null){
			BlogEntryResource res = new BlogEntryResourceAssembler().toResource(entry);
			return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
		}else{
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}

}
