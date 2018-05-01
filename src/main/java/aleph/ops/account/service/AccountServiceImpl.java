package aleph.ops.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aleph.ops.account.domain.AccountDAO;
import aleph.ops.account.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDAO accountDao;
	 
	public List<Account> getAccounts() {
		return accountDao.getAccounts();
	}


	public Boolean saveAccount(Account account) {
		return accountDao.saveAccount(account);
	}

	public Account getAccount(Long id) {
		return accountDao.getAccount(id);
	}

}
