package pe.senati.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.senati.entity.Futbolista;


public interface FutRepository extends JpaRepository<Futbolista, Integer> {

	
}
