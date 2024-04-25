package pe.senati.service;

import java.util.Collection;

import pe.senati.entity.Futbolista;

public interface FutbolistaService {

	public abstract void insert(Futbolista futbolista);
	public abstract void update(Futbolista futbolista);
	public abstract void delete(Integer id);
	public abstract  Futbolista findById(Integer id);
	public abstract  Collection<Futbolista> findAll();
}
