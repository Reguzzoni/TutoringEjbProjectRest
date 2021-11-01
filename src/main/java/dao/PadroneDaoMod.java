package dao;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import model.Padrone;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class PadroneDaoMod {
	@PersistenceContext(unitName = "persistenceUnit1") // tipo 'inject'
	private EntityManager em;
	
	@Resource
	UserTransaction uTransaction;
	
	public void save(Padrone t) {
			try {
				uTransaction.begin();
				
				em.persist(t);
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					uTransaction.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
		 
	
}
