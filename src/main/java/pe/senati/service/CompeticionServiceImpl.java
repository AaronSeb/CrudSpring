package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Competicion;
import pe.senati.repository.CompeticionRepository;

@Service
public class CompeticionServiceImpl implements CompeticionService {
	
	@Autowired
	private CompeticionRepository comperepository;

	public CompeticionServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public void insert(Competicion competicion) {
		comperepository.save(competicion);
		
	}

	@Override
	@Transactional
	public void update(Competicion competicion) {
		comperepository.save(competicion);
		
	}

	@Override
	@Transactional
	public void delete(Integer competicionId) {
		comperepository.deleteById(competicionId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Competicion finById(Integer competicionId) {
		return comperepository.findById(competicionId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Competicion> finAll() {
		return comperepository.findAll();
	}
	
	
	
}
