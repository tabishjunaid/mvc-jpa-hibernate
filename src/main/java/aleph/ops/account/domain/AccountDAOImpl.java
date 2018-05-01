package aleph.ops.account.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import aleph.ops.account.entity.Account;
import aleph.ops.common.config.PersistenceManager;

@Repository
public class AccountDAOImpl implements AccountDAO {

	public List<Account> getAccounts() {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        Query query = em.createQuery("SELECT a FROM Account a");
        
        List<Account> result = query.getResultList();
        return result;
	}

	public boolean saveAccount(Account account) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        return true;
	}

	public Account getAccount(Long id) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        Query query = em.createQuery("SELECT a FROM Account a where a.id=:id");
        query.setParameter("id", id);
        System.out.println("*****id=" + id);
        Account result = (Account)query.getSingleResult();
        return result;
	}

}
