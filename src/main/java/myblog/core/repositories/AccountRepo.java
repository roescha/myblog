package myblog.core.repositories;

import java.util.List;

import myblog.core.models.entities.Account;

public interface AccountRepo {
	public List<Account> findAllAccounts();

	public Account findAccount(Long id);

	public Account findAccountByName(String name);

	public Account createAccount(Account data);
}