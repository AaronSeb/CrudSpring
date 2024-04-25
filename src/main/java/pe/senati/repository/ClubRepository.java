package pe.senati.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.senati.entity.Club;
import pe.senati.entity.Competicion;

public interface ClubRepository extends JpaRepository<Club, Integer>{
	
	@Query(value="select cl.club_id,cl.nombre_club,co.competicion_id,co.nombre_competicion\r\n"
			+ "from competicion_participa cp \r\n"
			+ "inner join clubes cl on (cl.club_id = cp.club_id ) \r\n"
			+ "inner join competicion co on (co.competicion_id = cp.competicion_id)\r\n"
			+ "order by cl.club_id,co.competicion_id",nativeQuery=true)
	public abstract Collection<Object[]> findAllClubCompeticion();
	
	
	
	
	
	
	@Query(value="select co.competicion_id, co.nombre_competicion, co.cantidad_premio, co.f_inicio \r\n"
			+ "from competicion_participa cp \r\n"
			+ "inner join clubes cl on (cl.club_id = cp.club_id ) \r\n"
			+ "inner join competicion co on (co.competicion_id = cp.competicion_id)\r\n"
			+ "where cl.club_id = ?;",nativeQuery=true)
	public abstract Collection<Object[]> findAllCompeticion(Integer clubId);
	
	

}
