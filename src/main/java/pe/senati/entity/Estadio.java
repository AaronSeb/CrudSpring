package pe.senati.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="estadios")
public class Estadio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estadioId;
	
	@Column(unique = true,nullable = false)
	private String nombreEstadio;
	
	@Column
	private String ubicacion;
	
	@Column
	private Integer capacidad;
	
	
	@OneToOne
	@JoinColumn(name = "club_id",unique = true, nullable = true )
	private Club club;
	
	
	public Estadio() {
		// TODO Auto-generated constructor stub
	}

	public Estadio(Integer estadioId, String nombreEstadio, String ubicacion, Integer capacidad) {
		this.estadioId = estadioId;
		this.nombreEstadio = nombreEstadio;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
	}

	public Integer getEstadioId() {
		return estadioId;
	}

	public void setEstadioId(Integer estadioId) {
		this.estadioId = estadioId;
	}

	public String getNombreEstadio() {
		return nombreEstadio;
	}

	public void setNombreEstadio(String nombreEstadio) {
		this.nombreEstadio = nombreEstadio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
	
}
