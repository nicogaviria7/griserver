package co.edu.uniquindio.gri.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name = "PRODUCCIONBIBLIOGRAFICAG")
@Table(name = "BIBLIOGRAFICASG", schema = "gri")
public class ProduccionBGrupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "IDENTIFICADOR", length = 400)
	private String identificador;

	@Column(name = "AUTORES", length = 2000)
	private String autores;

	@Column(name = "ANIO", length = 10)
	private String anio;

	@Column(name = "REFERENCIA", length = 4000)
	private String referencia;

	@Column(name = "REPETIDO", length = 10)
	private String repetido;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GRUPOS_ID")
	@JsonIgnore
	private Grupo grupo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TIPO_ID")
	@JsonIgnore
	private Tipo tipo;

	public ProduccionBGrupo(long id, String identificador, String autores, String anio, String referencia,
			Tipo tipo, String repetido, Grupo grupo) {
		this.id = id;
		this.identificador = identificador;
		this.autores = autores;
		this.anio = anio;
		this.referencia = referencia;
		this.tipo = tipo;
		this.repetido = repetido;
		this.grupo = grupo;
	}

	
	public ProduccionBGrupo(long id, String identificador, String autores, String anio, String referencia) {
		this.id = id;
		this.identificador = identificador;
		this.autores = autores;
		this.anio = anio;
		this.referencia = referencia;
	}


	public ProduccionBGrupo() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getRepetido() {
		return repetido;
	}

	public void setRepetido(String repetido) {
		this.repetido = repetido;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		ProduccionBGrupo other = (ProduccionBGrupo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
