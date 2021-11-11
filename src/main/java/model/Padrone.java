package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "padrone")

@NamedQueries({
	@NamedQuery(
		    name=Padrone.NAMED_QUERY_ALL,
		    query="SELECT p FROM Padrone p"
		), //HQL >> for hibernate
	@NamedQuery(
		    name=Padrone.NAMED_QUERY_PER_RICERCA_BY_NOME,
		    query="SELECT p FROM Padrone p where p.nome = :"+Padrone.PARAM_QUERY_NOME
		), //HQL >> for hibernate
})
@JsonIgnoreProperties(value = { "cognome" })
public class Padrone implements Serializable{
	private static final long serialVersionUID = 1L;

	// named query listed
	public final static String NAMED_QUERY_ALL = "findAllOwners";
	public final static String NAMED_QUERY_PER_RICERCA_BY_NOME = "findOwnerByName";
	
	// parameters query listed
	public final static String PARAM_QUERY_NOME = "nome";
	
	@Id
	@Column(name = "padrone_id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	/*@OneToMany(fetch = FetchType.LAZY,  mappedBy="padrone") //nome che mappa l'entita'
	@Transient
	private List<Cane> cani;*/
	
	/*@ManyToMany (mappedBy = "padroneOfGatto")
	private Set<Gatto> gatto; //to insert in postgres*/

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome +
				", cognome=" + cognome +"]";
	}

}
