package co.edu.uniquindio.gri.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name = "PROGRAMAS")
@Table(name = "PROGRAMAS", schema = "gri")
public class Programa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FACULTADES_ID")
	private Facultad facultad;

	@ManyToMany(mappedBy = "programas", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Grupo> grupos = new ArrayList<Grupo>();

	public Programa() {
	}

	public Programa(long id, String nombre, Facultad facultad) {
		this.id = id;
		this.nombre = nombre;
		this.facultad = facultad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

}