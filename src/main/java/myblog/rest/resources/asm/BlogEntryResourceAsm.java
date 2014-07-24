package myblog.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import myblog.core.models.entities.BlogEntry;
import myblog.rest.mvc.BlogController;
import myblog.rest.mvc.BlogEntryController;
import myblog.rest.resources.BlogEntryResource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

	public BlogEntryResourceAsm() {
		super(BlogEntryController.class, BlogEntryResource.class);
	}

	@Override
	public BlogEntryResource toResource(BlogEntry blogEntry) {
		BlogEntryResource res = new BlogEntryResource();
		res.setTitle(blogEntry.getTitle());
		res.setContent(blogEntry.getContent());
		Link self = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
		res.add(self);
		if (blogEntry.getBlog() != null) {
			res.add((linkTo(BlogController.class).slash(blogEntry.getBlog().getId()).withRel("blog")));
		}
		return res;
	}

}
