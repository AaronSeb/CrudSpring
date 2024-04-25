package pe.senati.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="clubes")
public class Club implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clubId;
	
	@Column(unique = true)
	private String nombreClub;
	
	@Column
	private String nommbrePresidente;
	
	@DateTimeFormat(pattern="yyyy-MM-dd", iso = ISO.DATE)
	private LocalDate feFundacion;
	
	@Column(unique = true, nullable = false)
	private String correo;
	
	@Column
	private String direccion;
	
	@Column
	private String pais;
	
	@Column
	private Integer telefono;
	
	@Column
	private String direcT;
	
	@Column
	private String duenio;
	
	@OneToMany(mappedBy = "club")
	private Collection<Futbolista> itemsFutbolista=new ArrayList<>();
	
	@OneToOne(mappedBy = "club")
	private Estadio estadio;
	
	@ManyToOne
	@JoinColumn(name = "liga_id", nullable = true)
	private Liga liga;
	
	
	@ManyToMany
	@JoinTable(name = "competicion_participa",joinColumns = @JoinColumn(name="club_id"), inverseJoinColumns = @JoinColumn(name="competicion_id"))
    Set<Competicion> participaCompeticion;
	
	public Club() {
	}

	public Club(Integer clubId, String nombreClub, String nommbrePresidente, LocalDate feFundacion, String correo,
			String direccion, String pais, Integer telefono, String directT, String duenio) {

		this.clubId = clubId;
		this.nombreClub = nombreClub;
		this.nommbrePresidente = nommbrePresidente;
		this.feFundacion = feFundacion;
		this.correo = correo;
		this.direccion = direccion;
		this.pais = pais;
		this.telefono = telefono;
		this.direcT =directT;
		this.duenio =duenio;
	}
	
	public void addCompeticion(Competicion competicion) {
		participaCompeticion.add(competicion);
	}

	public Integer getClubId() {
		return clubId;
	}

	public void setClubId(Integer clubId) {
		this.clubId = clubId;
	}

	public String getNombreClub() {
		return nombreClub;
	}

	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}

	public String getNommbrePresidente() {
		return nommbrePresidente;
	}

	public void setNommbrePresidente(String nommbrePresidente) {
		this.nommbrePresidente = nommbrePresidente;
	}

	public LocalDate getFeFundacion() {
		return feFundacion;
	}

	public void setFeFundacion(LocalDate feFundacion) {
		this.feFundacion = feFundacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	
	public String getDirecT() {
		return direcT;
	}

	public void setDirecT(String direcT) {
		this.direcT = direcT;
	}

	public String getDuenio() {
		return duenio;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}

	public Collection<Futbolista> getItemsFutbolista() {
		return itemsFutbolista;
	}

	public void setItemsFutbolista(Collection<Futbolista> itemsFutbolista) {
		this.itemsFutbolista = itemsFutbolista;
	}

	///////////////////////////////////////////////
	
	
	///////////////////////////////////////////////
	
	
	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	
	
	////////////////////////////////////////////////
	@PreRemove
	public void nullarClub() {
		
		if(estadio == null || itemsFutbolista ==null) {
			estadio.setClub(null);
			itemsFutbolista.forEach(fut -> fut.setClub(null));
        }else {
        	itemsFutbolista.forEach(fut -> fut.setClub(null));
        	estadio.setClub(null);
        }
			
	}
////////////////////////////////////////////////////
	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public Set<Competicion> getParticipaCompeticion() {
		return participaCompeticion;
	}

	public void setParticipaCompeticion(Set<Competicion> participaCompeticion) {
		this.participaCompeticion = participaCompeticion;
	}
	
	
	
	
}
