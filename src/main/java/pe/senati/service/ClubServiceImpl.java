package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Club;
import pe.senati.entity.Competicion;
import pe.senati.repository.ClubRepository;

@Service
public class ClubServiceImpl implements ClubService {
	
	@Autowired
	private ClubRepository clubRepository;
	
	
	public ClubServiceImpl() {
		
	}

	@Override
	@Transactional
	public void insert(Club club) {
		clubRepository.save(club);
		
	}

	@Override
	@Transactional
	public void update(Club club) {
		clubRepository.save(club);
		
	}

	@Override
	@Transactional
	public void delete(Integer clubId) {
		clubRepository.deleteById(clubId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Club findById(Integer clubId) {
		
		return clubRepository.findById(clubId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Club> findAll() {
		
		return clubRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Object[]> findAllCompeticion(Integer clubId) {
		
		return clubRepository.findAllCompeticion(clubId);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Object[]> findAllClubCompeticion() {
		
		return clubRepository.findAllClubCompeticion();
	}
	
	
	

}
