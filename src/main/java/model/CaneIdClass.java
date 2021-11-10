package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CaneIdClass implements Serializable { //

	private static final long serialVersionUID = 1L;

	private int caneId;

	private String nome;
	
	public int getCaneId() {
		return caneId;
	}
	public void setCaneId(int caneId) {
		this.caneId = caneId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + caneId;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaneIdClass other = (CaneIdClass) obj;
		if (caneId != other.caneId)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
