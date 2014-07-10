package myblog.core.repositories;

import myblog.core.models.entities.Account;
import myblog.core.models.entities.Blog;



public interface AccountRepo {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
}
