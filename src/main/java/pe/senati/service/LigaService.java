package pe.senati.service;

import java.util.Collection;

import pe.senati.entity.Liga;

public interface LigaService {

	public abstract void insert(Liga liga);
	public abstract void update(Liga liga);
	public abstract void delete(Integer ligaId);
	public abstract Liga findById(Integer ligaId);
	public abstract Collection<Liga> findAll();
	
}
