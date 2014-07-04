package myblog.core.services;

import myblog.core.models.entities.BlogEntry;

public interface BlogEntryService {

	BlogEntry findBlogEntry(Long id);

	BlogEntry deleteBlogEntry(Long id);

	BlogEntry updateBlogEntry(Long id, BlogEntry data);

}
