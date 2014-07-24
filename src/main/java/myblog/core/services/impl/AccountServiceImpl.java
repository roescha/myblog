package myblog.core.services.impl;

import myblog.core.models.entities.Account;
import myblog.core.models.entities.Blog;
import myblog.core.repositories.AccountRepo;
import myblog.core.repositories.BlogRepo;
import myblog.core.services.AccountService;
import myblog.core.services.exceptions.AccountDoesNotExistException;
import myblog.core.services.exceptions.AccountExistsException;
import myblog.core.services.exceptions.BlogExistsException;
import myblog.core.services.util.AccountList;
import myblog.core.services.util.BlogList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountRepo accountRepo;

  @Autowired
  private BlogRepo blogRepo;

  @Override
  public Account findAccount(Long id) {
      return accountRepo.findAccount(id);
  }

  @Override
  public Account createAccount(Account data) {
      Account account = accountRepo.findAccountByName(data.getName());
      if(account != null)
      {
          throw new AccountExistsException();
      }
      return accountRepo.createAccount(data);
  }

  @Override
  public Blog createBlog(Long accountId, Blog data) {
      Blog blogSameTitle = blogRepo.findBlogByTitle(data.getTitle());

      if(blogSameTitle != null)
      {
          throw new BlogExistsException();
      }

      Account account = accountRepo.findAccount(accountId);
      if(account == null)
      {
          throw new AccountDoesNotExistException();
      }

      Blog createdBlog = blogRepo.createBlog(data);

      createdBlog.setOwner(account);

      return createdBlog;
  }

  @Override
  public BlogList findBlogsByAccount(Long accountId) {
      Account account = accountRepo.findAccount(accountId);
      if(account == null)
      {
          throw new AccountDoesNotExistException();
      }
      return new BlogList(blogRepo.findBlogsByAccount(accountId));
  }

  @Override
  public AccountList findAllAccounts() {
      return new AccountList(accountRepo.findAllAccounts());
  }

  @Override
  public Account findByAccountName(String name) {
      return accountRepo.findAccountByName(name);
  }
}