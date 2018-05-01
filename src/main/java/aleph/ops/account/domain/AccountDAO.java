package aleph.ops.account.domain;

import java.util.List;

import aleph.ops.account.entity.Account;

public interface AccountDAO {
	
	public List<Account> getAccounts();
	 
    public boolean saveAccount(Account account);
    
    public Account getAccount(Long id);
}
