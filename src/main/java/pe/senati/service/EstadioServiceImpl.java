package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Estadio;
import pe.senati.repository.EstadioRepository;

@Service
public class EstadioServiceImpl implements EstadioService {

	//constructor
	public EstadioServiceImpl() {
	}
	
	@Autowired
	private EstadioRepository estadioRepository;

	@Override
	@Transactional
	public void insert(Estadio estadio) {
		estadioRepository.save(estadio);
		
	}

	@Override
	@Transactional
	public void update(Estadio estadio) {
		estadioRepository.save(estadio);
		
	}

	@Override
	@Transactional
	public void delete(Integer estadioId) {
		estadioRepository.deleteById(estadioId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Estadio findById(Integer estadioId) {
		
		return estadioRepository.findById(estadioId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Estadio> findAll() {
		
		return estadioRepository.findAll();
	}
	
	
	
}
