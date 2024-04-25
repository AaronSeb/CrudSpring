package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Futbolista;
import pe.senati.repository.FutRepository;

@Service
public class FutbolistaServiceImpl implements FutbolistaService {

	@Autowired
	private FutRepository futrepo;
	
	
	public FutbolistaServiceImpl() {
	}
	
	@Transactional
	@Override
	public void insert(Futbolista futbolista) {
	
		futrepo.save(futbolista);
	}

	@Override
	@Transactional
	public void update(Futbolista futbolista) {
		futrepo.save(futbolista);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		futrepo.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Futbolista findById(Integer id) {
		return futrepo.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Futbolista> findAll() {
	
		return futrepo.findAll();
	}
	
	
}
