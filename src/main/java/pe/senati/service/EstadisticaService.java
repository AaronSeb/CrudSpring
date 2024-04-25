package pe.senati.service;

import java.util.Collection;

import pe.senati.entity.Estadistica;

public interface EstadisticaService {
	public abstract void insert(Estadistica estadistica);
	public abstract void update(Estadistica estadistica);
	public abstract void delete(Integer estadisticaId);
	public abstract Estadistica findById(Integer estadisticaId);
	public abstract Collection<Estadistica> findAll();
}
