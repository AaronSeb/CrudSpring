package pe.senati.service;

import java.util.Collection;

import pe.senati.entity.Estadio;

public interface EstadioService {
	public abstract void insert(Estadio estadio);
	public abstract void update(Estadio estadio);
	public abstract void delete(Integer estadioId);
	public abstract Estadio findById(Integer estadioId);
	public abstract Collection<Estadio> findAll();
}
