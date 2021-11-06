package dao;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import model.Cane;
import model.Padrone;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class PadroneDaoMod {
	
	@PersistenceContext(unitName = "persistenceUnit1") // tipo 'inject'
	private EntityManager em;
	
	@Resource
	UserTransaction uTransaction;
	
	public void save(Padrone padrone, Cane cane) 
			throws 
				IllegalStateException, SecurityException,
				SystemException, RollbackException,
				HeuristicMixedException, HeuristicRollbackException 		
	{
			try {
				uTransaction.begin();
				
				em.persist(padrone);
				em.persist(cane);
				
				uTransaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
				uTransaction.rollback();
			}
	}
		 
	
}
