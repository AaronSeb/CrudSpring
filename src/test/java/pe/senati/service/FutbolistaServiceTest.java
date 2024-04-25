package pe.senati.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import pe.senati.DemoMemoryApplicationTests;
import pe.senati.entity.Futbolista;

@SpringJUnitConfig(classes =DemoMemoryApplicationTests.class)
public class FutbolistaServiceTest {

	@Autowired
	private FutbolistaService futService;
	
	public FutbolistaServiceTest() {
	}
	
	@Test
	public void Inserting() {
		
		//nuevo empleado
		Futbolista f5= new Futbolista("Vin Dicj", 'M', LocalDate.of(1994, 10, 11), "defensa", "Paises Bajos","derecho",98);
		//verificar si es not null
		assertThat(f5,is(notNullValue()));
		
		//si futbolista es not null
		//insertar
		futService.insert(f5);
	}
	
	@Test
	public void Updating() {
		//buscar futbolista por id
		Futbolista futbolista= futService.findById(2);
		
		//verificar si es not null
		assertThat(futbolista,is(notNullValue()));
		
		//si el futbolista es no null, se actualiza
		//editar
		futbolista.setNombre("Ricardino");
		futbolista.setPais("Portugal");
		futbolista.setFnaci(LocalDate.of(1990, 10, 21));
		
		//actualizar
		futService.update(futbolista);
	}
	
	@Test
	public void Delete() {
		
		Futbolista futbolista =futService.findById(3);
		
		assertThat(futbolista,is(notNullValue()));
		
		futService.delete(futbolista.getId());
	}
	
}
