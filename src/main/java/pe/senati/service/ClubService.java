package pe.senati.service;

import java.util.Collection;

import pe.senati.entity.Club;
import pe.senati.entity.Competicion;

public interface ClubService {
	public abstract void insert(Club club);
	public abstract void update(Club club);
	public abstract void delete(Integer clubId);
	public abstract Club findById(Integer clubId);
	public abstract Collection<Club> findAll();
	
	public abstract Collection<Object[]> findAllClubCompeticion();
	public abstract Collection<Object[]> findAllCompeticion(Integer clubId);
	
}
