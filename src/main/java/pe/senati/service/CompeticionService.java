package pe.senati.service;

import java.util.Collection;

import pe.senati.entity.Competicion;

public interface CompeticionService {

	public abstract void insert(Competicion competicion);
	public abstract void update(Competicion competicion);
	public abstract void delete(Integer competicionId);
	public abstract Competicion finById(Integer competicionId);
	public abstract Collection<Competicion>finAll();
}
