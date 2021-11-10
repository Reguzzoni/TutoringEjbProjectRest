package dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Padrone;

@Model
public class PadroneDao /*implements Dao<Padrone>*/ {

	@PersistenceContext(unitName = "persistenceUnit1") // tipo 'inject'
	private EntityManager em;

	public Padrone get(int id) {
		return em.find(Padrone.class, id);
	}

	//	@Override
	public List<Padrone> getAll() {
		return em.createNamedQuery("findAllOwners", Padrone.class)
				.getResultList();
	}

	//	@Override
	public void save(Padrone padroneInput) {
		//padrone esiste nel DB?
		Padrone padroneEsistente = em.find(Padrone.class, padroneInput.getId());
		if(padroneEsistente != null) {
			// entita gia esiste nel DB
			padroneEsistente.setNome(padroneInput.getNome());
			padroneEsistente.setCognome(padroneInput.getCognome());
			em.merge(padroneEsistente);

		} else {
			// entita prima volta che la vedo nel DB!
			em.persist(padroneInput);
		}
	}

	/**
	 * Questo metodo serve per salvare / sovrascrivere un instanza di padrone nel database
	 * @param nome rappresenta il nome del padrone
	 * @param cognome rappresenta il cognome del padrone
	 * @param id rappresenta l'id del padrone
	 */
	public void save(String nome, String cognome, int id) {
		//padrone esiste nel DB?
		Padrone padroneEsistente = em.find(Padrone.class, id);
		if(padroneEsistente != null) {
			// entita gia esiste nel DB
			padroneEsistente.setNome(nome);
			padroneEsistente.setCognome(cognome);
			em.merge(padroneEsistente);

		} else {
			// entita prima volta che la vedo nel DB!
			Padrone padroneToSave = new Padrone();
			padroneToSave.setNome(nome);
			padroneToSave.setCognome(cognome);
			padroneToSave.setId(id);
			em.persist(padroneToSave);
		}
	}

	//	@Override
	public void update(Padrone t) {//
		em.merge(t);
	}

	//	@Override
	public void delete(Padrone t) {
		em.remove(t);
	}


}
