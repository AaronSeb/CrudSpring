package pe.senati.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.senati.entity.Club;
import pe.senati.entity.Competicion;
import pe.senati.service.ClubService;
import pe.senati.service.CompeticionService;

@Controller
@RequestMapping("/club_competicion")
public class ClubCpmpeticionController {
	
	public ClubCpmpeticionController() {
	}
	@Autowired
	private ClubService clubService;
	
	@Autowired
	private CompeticionService competicionService;
	
	
	private Collection<Competicion> carrito=null;
	
	@RequestMapping("/mostrar/{clubId}")
	public String mostrar_GET(Model model, Map map, @PathVariable Integer clubId,@RequestParam(defaultValue = "false")boolean parameter) {
		
		Club clubDb = clubService.findById(clubId);
		
		if(parameter ==false) {
			carrito = convert(clubService.findAllCompeticion(clubId));
			
		}
		
		model.addAttribute("club", clubDb);
		map.put("bCompeticiones", competicionService.finAll());
		map.put("bCarrito",carrito);
		return "ClubCompeticion/mostrar";
	}
	
	@GetMapping("/agregar/{competicionId}/{clubId}")
	public String agregar_GET(@PathVariable Integer competicionId,@PathVariable Integer clubId) {
		if(competicionId!=0) {
			
			Competicion competicion= competicionService.finById(competicionId);
			
			carrito.add(competicion);
			
		}
		
		
		return "redirect:/club_competicion/mostrar/"+ clubId +"?parameter=true";
	}
	
	@PostMapping("/mostrar/{clubId}")
	public String mostrar_POST(@PathVariable Integer clubId) {
		
		Club clubDb= clubService.findById(clubId);
		
		//recorrer proyecto por proyecto 
		for(Competicion competicion:carrito) {
			
			clubDb.addCompeticion(competicion);
		}
		//actualizar el estado del empleado
		clubService.update(clubDb);
			
		return "redirect:/club/listar";
	}
	

	@GetMapping("/listar")
	public String listar_GET(Map map) {
		
		map.put("bClubs", clubService.findAll());
		map.put("bClubCompeticion", clubService.findAllClubCompeticion());
		
		return "ClubCompeticion/listar";
	}
	
	
	
	
	
	
	//metodo para convertir el objeto a competicion
	
	public Collection<Competicion> convert(Collection<Object[]> objects){
		
		Collection<Competicion> competiciones = new ArrayList<>();
		
		for(Object[] object:objects) {
			
			Integer competicionId=Integer.parseInt(object[0].toString());
			String nombreCompeticion=object[1].toString();
			Double cantidadPremio=Double.parseDouble(object[2].toString());
			LocalDate fInicio=LocalDate.parse(object[3].toString()); 
			
			Competicion competicion = new Competicion(competicionId,nombreCompeticion,cantidadPremio,fInicio);
			
			competiciones.add(competicion);
			
		}
		
		
		return competiciones;
	}
}
