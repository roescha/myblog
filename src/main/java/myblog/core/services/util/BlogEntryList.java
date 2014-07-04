package myblog.core.services.util;

import java.util.ArrayList;
import java.util.List;

import myblog.core.models.entities.BlogEntry;

public class BlogEntryList {
	private List<BlogEntry> entries = new ArrayList<>();
	private Long blogId;

	public List<BlogEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<BlogEntry> entries) {
		this.entries = entries;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

}
