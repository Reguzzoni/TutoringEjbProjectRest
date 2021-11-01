package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cane")
@NamedQuery(
	    name="findAllCani",
	    query="SELECT c FROM Cane c"
	)
public class Cane implements Serializable{ //
	//Eclipse:(1) Select: 
	//(Your Project) -> Properties -> JPA;
	// (2) Look for "Persistent class management" and select the option "Discover annotated classes automatically"; 
	//(3) Press "Apply".

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cane_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int caneId;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "razza")
	private String razza;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "padrone_id")
	private Padrone padrone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRazza() {
		return razza;
	}
	public void setRazza(String razza) {
		this.razza = razza;
	}
}
