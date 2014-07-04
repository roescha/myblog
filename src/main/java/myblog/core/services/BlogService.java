package myblog.core.services;

import myblog.core.models.entities.Blog;
import myblog.core.models.entities.BlogEntry;
import myblog.core.services.util.BlogEntryList;
import myblog.core.services.util.BlogList;

public interface BlogService {
	BlogEntry createBlogEntry(Long blogId, BlogEntry data);

	BlogList findAllBlogs();

	BlogEntryList findAllBlogEntries(Long blogId);

	Blog findBlog(Long id);

}
