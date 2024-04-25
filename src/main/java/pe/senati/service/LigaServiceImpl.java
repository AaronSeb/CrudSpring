package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Liga;
import pe.senati.repository.LigaRepository;

@Service
public class LigaServiceImpl implements LigaService{

	@Autowired
	private LigaRepository repository;
	
	
	public LigaServiceImpl() {
	
	}

	@Override
	@Transactional
	public void insert(Liga liga) {
		repository.save(liga);
		
	}

	@Override
	@Transactional
	public void update(Liga liga) {
		repository.save(liga);
		
	}

	@Override
	@Transactional
	public void delete(Integer ligaId) {
		repository.deleteById(ligaId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Liga findById(Integer ligaId) {
		return repository.findById(ligaId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Liga> findAll() {
		return repository.findAll();
	}
	
	
}
