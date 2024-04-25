package pe.senati.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
@Table(name="futbolistas")
public class Futbolista implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private Character sexo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd", iso = ISO.DATE)
	private LocalDate fnaci;
	
	@Column
	private String posicion;
	
	
	@Column
	private String pais;
	
	@Column
	private String pieDominante;
	
	@Column
	private Integer skill;
	
	@ManyToOne
	@JoinColumn(name="club_id",nullable = true)
	private Club club;
	
	@OneToOne(mappedBy = "futbolista",cascade = CascadeType.REMOVE)
	private Estadistica estadistica;
	
	public Futbolista() {
	}


	public Futbolista(Integer id, String nombre, Character sexo, LocalDate fnaci, String posicion,
			String pais, String pieDominante,Integer skill) {
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
		this.fnaci = fnaci;
		this.posicion = posicion;
		this.pais = pais;
		this.pieDominante = pieDominante;
		this.skill = skill;
	}
	
	public Futbolista(String nombre, Character sexo, LocalDate fnaci, String posicion,
			String pais, String pieDominante,Integer skill) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.fnaci = fnaci;
		this.posicion = posicion;
		this.pais = pais;
		this.pieDominante = pieDominante;
		this.skill = skill;
	}
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Character getSexo() {
		return sexo;
	}


	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}


	public LocalDate getFnaci() {
		return fnaci;
	}


	public void setFnaci(LocalDate fnaci) {
		this.fnaci = fnaci;
	}


	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}
	
	


	public String getPieDominante() {
		return pieDominante;
	}


	public void setPieDominante(String pieDominante) {
		this.pieDominante = pieDominante;
	}


	public Integer getSkill() {
		return skill;
	}


	public void setSkill(Integer skill) {
		this.skill = skill;
	}


	public Club getClub() {
		return club;
	}


	public void setClub(Club club) {
		this.club = club;
	}


	public Estadistica getEstadistica() {
		return estadistica;
	}


	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}


	
	
	
}


