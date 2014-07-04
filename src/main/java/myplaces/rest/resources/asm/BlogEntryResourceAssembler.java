package myplaces.rest.resources.asm;

import static  org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import myplaces.core.entities.BlogEntry;
import myplaces.rest.mvc.BlogEntryController;
import myplaces.rest.resources.BlogEntryResource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogEntryResourceAssembler extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {
	
	public BlogEntryResourceAssembler(){
		super(BlogEntryController.class, BlogEntryResource.class);
	}

	@Override
	public BlogEntryResource toResource(BlogEntry blogEntry) {
		BlogEntryResource res = new BlogEntryResource();
		res.setTitle(blogEntry.getTitle());
		//Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(blogEntry.getId())).withSelfRel();
		Link link = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
		res.add(link.withSelfRel());
		return res;
		
	}

}
