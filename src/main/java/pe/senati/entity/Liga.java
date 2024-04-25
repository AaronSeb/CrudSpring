package pe.senati.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "ligas")
public class Liga implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ligaId;
	
	@Column
	private String nombre;
	
	@Column(unique = true, nullable = false)
	private String pais;
	
	@DateTimeFormat(pattern="yyyy-MM-dd", iso = ISO.DATE)
	private LocalDate fInicio;
	
	@Column
	private Double cantidadPremio;
	
	@OneToMany(mappedBy = "liga")
	private Collection<Club>itemsClub= new ArrayList<>();
	
	
	public Liga() {
		// TODO Auto-generated constructor stub
	}

	public Liga(Integer ligaId, String nombre, String pais, LocalDate fInicio, Double cantidadPremio) {
		this.ligaId = ligaId;
		this.nombre = nombre;
		this.pais = pais;
		this.fInicio = fInicio;
		this.cantidadPremio = cantidadPremio;
	}

	public Integer getLigaId() {
		return ligaId;
	}

	public void setLigaId(Integer ligaId) {
		this.ligaId = ligaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public LocalDate getfInicio() {
		return fInicio;
	}

	public void setfInicio(LocalDate fInicio) {
		this.fInicio = fInicio;
	}

	public Double getCantidadPremio() {
		return cantidadPremio;
	}

	public void setCantidadPremio(Double cantidadPremio) {
		this.cantidadPremio = cantidadPremio;
	}

	public Collection<Club> getItemsClub() {
		return itemsClub;
	}

	public void setItemsClub(Collection<Club> itemsClub) {
		this.itemsClub = itemsClub;
	}
	
	@PreRemove
	public void nullarLiga() {
		itemsClub.forEach(clu->clu.setLiga(null));
	}
	
}
