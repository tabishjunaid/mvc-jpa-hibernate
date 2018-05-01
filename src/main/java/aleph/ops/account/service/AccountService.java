package aleph.ops.account.service;

import java.util.List;

import aleph.ops.account.entity.Account;

public interface AccountService {
	
	public List<Account> getAccounts();
	public Account getAccount(Long id);
	public Boolean saveAccount(Account account);
	
}
