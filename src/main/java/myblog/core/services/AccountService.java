package myblog.core.services;

import myblog.core.models.entities.Account;
import myblog.core.models.entities.Blog;
import myblog.core.services.util.AccountList;
import myblog.core.services.util.BlogList;

public interface AccountService {
	public Account findAccount(Long id);

	public Account createAccount(Account data);

	public Blog createBlog(Long accountId, Blog data);

	public BlogList findBlogsByAccount(Long accountId);

	public AccountList findAllAccounts();

	public Account findByAccountName(String name);
}
