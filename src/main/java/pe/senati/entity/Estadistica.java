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
@Table(name = "estadisticas")
public class Estadistica implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estadisticaId;
	
	@Column
	private Integer asistencias;
	
	@Column
	private Integer goles;
	
	@Column
	private Integer balonOro;
	
	@Column
	private Integer botaOro;
	
	@Column
	private Integer mundial;
	
	@Column
	private Integer champions;
	
	@Column
	private Integer libertadores;
	
	@Column
	private Integer copaDeLiga;
	
	@Column
	private Integer partidos;
	
	@OneToOne
	@JoinColumn(name ="id",unique = true,nullable = false)
	private Futbolista futbolista;
	
	
	public Estadistica() {
	}
	
	
	
	public Estadistica(Integer estadisticaId, Integer asistencias, Integer goles, Integer balonOro, Integer botaOro,
			Integer mundial, Integer champions, Integer libertadores, Integer copaDeLiga, Integer partidos) {
		this.estadisticaId = estadisticaId;
		this.asistencias = asistencias;
		this.goles = goles;
		this.balonOro = balonOro;
		this.botaOro = botaOro;
		this.mundial = mundial;
		this.champions = champions;
		this.libertadores = libertadores;
		this.copaDeLiga = copaDeLiga;
		this.partidos = partidos;
	}



	public Integer getEstadisticaId() {
		return estadisticaId;
	}



	public void setEstadisticaId(Integer estadisticaId) {
		this.estadisticaId = estadisticaId;
	}



	public Integer getAsistencias() {
		return asistencias;
	}



	public void setAsistencias(Integer asistencias) {
		this.asistencias = asistencias;
	}



	public Integer getGoles() {
		return goles;
	}



	public void setGoles(Integer goles) {
		this.goles = goles;
	}



	public Integer getBalonOro() {
		return balonOro;
	}



	public void setBalonOro(Integer balonOro) {
		this.balonOro = balonOro;
	}



	public Integer getBotaOro() {
		return botaOro;
	}



	public void setBotaOro(Integer botaOro) {
		this.botaOro = botaOro;
	}



	public Integer getMundial() {
		return mundial;
	}



	public void setMundial(Integer mundial) {
		this.mundial = mundial;
	}



	public Integer getChampions() {
		return champions;
	}



	public void setChampions(Integer champions) {
		this.champions = champions;
	}



	public Integer getLibertadores() {
		return libertadores;
	}



	public void setLibertadores(Integer libertadores) {
		this.libertadores = libertadores;
	}



	public Integer getCopaDeLiga() {
		return copaDeLiga;
	}



	public void setCopaDeLiga(Integer copaDeLiga) {
		this.copaDeLiga = copaDeLiga;
	}
	

	public Integer getPartidos() {
		return partidos;
	}



	public void setPartidos(Integer partidos) {
		this.partidos = partidos;
	}



	public Futbolista getFutbolista() {
		return futbolista;
	}



	public void setFutbolista(Futbolista futbolista) {
		this.futbolista = futbolista;
	}
	
	
	
	
	
}
