package co.edu.uniquindio.gri.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 */
@Embeddable
public class CompositeKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "grupos_id") 
	private long grupo;

	@Column(name = "investigadores_id")
	private long investigador;

	public CompositeKey(long grupo_id, long investigador_id) {
		this.grupo = grupo_id;
		this.investigador = investigador_id;
	}

	public CompositeKey() {
		
	}
	
	public long getGrupo() {
		return grupo;
	}

	public void setGrupo(long grupo) {
		this.grupo = grupo;
	}

	public long getInvestigador() {
		return investigador;
	}

	public void setInvestigador(long investigador) {
		this.investigador = investigador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (grupo ^ (grupo >>> 32));
		result = prime * result + (int) (investigador ^ (investigador >>> 32));
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
		CompositeKey other = (CompositeKey) obj;
		if (grupo != other.grupo)
			return false;
		if (investigador != other.investigador)
			return false;
		return true;
	}
}
