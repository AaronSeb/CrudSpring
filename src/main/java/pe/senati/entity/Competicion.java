package pe.senati.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Competicion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer competicionId;
	
	@Column
	private String nombreCompeticion;
	
	@Column
	private Double cantidadPremio;
	
	@DateTimeFormat(pattern="yyyy-MM-dd", iso = ISO.DATE)
	private LocalDate fInicio;
	
	@ManyToMany(mappedBy = "participaCompeticion")
    Set<Club> participa;
	
	
	public Competicion() {
		// TODO Auto-generated constructor stub
	}

	public Competicion(Integer competicionId, String nombreCompeticion, Double cantidadPremio, LocalDate fInicio) {
		this.competicionId = competicionId;
		this.nombreCompeticion = nombreCompeticion;
		this.cantidadPremio = cantidadPremio;
		this.fInicio= fInicio;
	}

	public Integer getCompeticionId() {
		return competicionId;
	}

	public void setCompeticionId(Integer competicionId) {
		this.competicionId = competicionId;
	}

	public String getNombreCompeticion() {
		return nombreCompeticion;
	}

	public void setNombreCompeticion(String nombreCompeticion) {
		this.nombreCompeticion = nombreCompeticion;
	}

	public Double getCantidadPremio() {
		return cantidadPremio;
	}

	public void setCantidadPremio(Double cantidadPremio) {
		this.cantidadPremio = cantidadPremio;
	}
	
	public LocalDate getfInicio() {
		return fInicio;
	}

	public void setfInicio(LocalDate fInicio) {
		this.fInicio = fInicio;
	}

	public Set<Club> getParticipa() {
		return participa;
	}

	public void setParticipa(Set<Club> participa) {
		this.participa = participa;
	}

	

	
	
	
	
}
