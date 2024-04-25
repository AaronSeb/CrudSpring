package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Estadistica;
import pe.senati.repository.EstadisticaRepository;

@Service
public class EstadisticaServiceImpl implements EstadisticaService {

	@Autowired
	private EstadisticaRepository estadisticaRepo;
	
	//constructor
	public EstadisticaServiceImpl() {
	
	}

	@Override
	@Transactional
	public void insert(Estadistica estadistica) {
		estadisticaRepo.save(estadistica);
		
	}

	@Override
	@Transactional
	public void update(Estadistica estadistica) {
		estadisticaRepo.save(estadistica);
		
	}

	@Override
	@Transactional
	public void delete(Integer estadisticaId) {
		estadisticaRepo.deleteById(estadisticaId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Estadistica findById(Integer estadisticaId) {
		
		return estadisticaRepo.findById(estadisticaId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Estadistica> findAll() {
		
		return estadisticaRepo.findAll();
	}

	
}
