package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import model.Cane;

@Stateless
//requires_new
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
//prova con 1 o piu transazioni contemporane
public class CaneDao implements Dao<Cane>{
	//The name of the persistence unit as defined in the persistence.xml file. 
	//If the unitName element is specified, the persistence unit for the entity manager that is accessible in JNDI must have the same name.
	@PersistenceContext(unitName = "persistenceUnit1")
	private EntityManager em;
	
//	public Cane getById(int caneId) {
//	return em.find(Cane.class, caneId);
//	}

	@Override
	public Cane get(int id) {
		// TODO Auto-generated method stub
		return em.find(Cane.class, id);
	}

	@Override
	public List<Cane> getAll() {
		return em.createNamedQuery("findAllCani", Cane.class)
				.getResultList();
	}

	@Override
	public void save(Cane t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cane t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cane t) {
		// TODO Auto-generated method stub
		
	}

}
