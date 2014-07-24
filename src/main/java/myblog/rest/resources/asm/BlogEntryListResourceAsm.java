package myblog.rest.resources.asm;

import java.util.List;

import myblog.core.services.util.BlogEntryList;
import myblog.rest.mvc.BlogController;
import myblog.rest.resources.BlogEntryListResource;
import myblog.rest.resources.BlogEntryResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class BlogEntryListResourceAsm extends ResourceAssemblerSupport<BlogEntryList, BlogEntryListResource> {
  public BlogEntryListResourceAsm() {
      super(BlogController.class, BlogEntryListResource.class);
  }

  @Override
  public BlogEntryListResource toResource(BlogEntryList list) {
      List<BlogEntryResource> resources = new BlogEntryResourceAsm().toResources(list.getEntries());
      BlogEntryListResource listResource = new BlogEntryListResource();
      listResource.setEntries(resources);
      listResource.add(linkTo(methodOn(BlogController.class).findAllBlogEntries(list.getBlogId())).withSelfRel());
      return listResource;
  }
}