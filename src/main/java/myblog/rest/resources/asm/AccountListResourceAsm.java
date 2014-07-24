package myblog.rest.resources.asm;

import java.util.List;

import myblog.core.services.util.AccountList;
import myblog.rest.mvc.AccountController;
import myblog.rest.resources.AccountListResource;
import myblog.rest.resources.AccountResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class AccountListResourceAsm extends
		ResourceAssemblerSupport<AccountList, AccountListResource> {

	public AccountListResourceAsm() {
		super(AccountController.class, AccountListResource.class);
	}

	@Override
	public AccountListResource toResource(AccountList accountList) {
		List<AccountResource> resList = new AccountResourceAsm().toResources(accountList.getAccounts());
		AccountListResource finalRes = new AccountListResource();
		finalRes.setAccounts(resList);
		return finalRes;
	}
}