package myblog.core.services;

import myblog.core.models.entities.Account;
import myblog.core.models.entities.Blog;

public interface AccountService {
	Account findAccount(Long id);

	Account createAccount(Account data);

	Blog createBlog(Long accountId, Blog data);
}
