package pe.senati.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.senati.entity.Estadio;
import pe.senati.service.ClubService;
import pe.senati.service.EstadioService;

@Controller
@RequestMapping("/estadio")
public class EstadioController {

	public EstadioController() {
	}
	
	@Autowired
	private EstadioService estadioService;
	
	@Autowired
	private ClubService clubService;
	
	@GetMapping("/listar")
	public String listar_GET(Map map) {
		map.put("estadios", estadioService.findAll());
		return "Estadio/listar";
	}
	
	@GetMapping("/registrar")
	public String registrar_GET(Model model, Map map) {
		Estadio estadioNull= new Estadio();
		model.addAttribute("estadio", estadioNull);
		map.put("bclubes", clubService.findAll());
		return "Estadio/registrar";
	}
	
	@PostMapping("/registrar")
	public String registrar_POST(Estadio estadio) {
		estadioService.insert(estadio);
		return "redirect:/estadio/listar";
	}
	
	@GetMapping("/editar/{estadioId}")
	public String editar_GET(Model model, Map map, @PathVariable Integer estadioId) {
		
		Estadio estadioDb= estadioService.findById(estadioId);
		model.addAttribute("estadio", estadioDb);
		map.put("bclubes", clubService.findAll());
		return "Estadio/editar";
	}
	
	@PostMapping("/editar/{estadioId}")
	public String editar_POST(Estadio estadio) {
		
		estadioService.update(estadio);
		return "redirect:/estadio/listar";
	}
	
	@GetMapping("/eliminar/{estadioId}")
	public String eliminar_GET(Model model, @PathVariable Integer estadioId) {
		
		Estadio estadioDb= estadioService.findById(estadioId);
		model.addAttribute("estadio", estadioDb);
		return "Estadio/eliminar";
	}
	
	@PostMapping("/eliminar/{estadioId}")
	public String eliminar_POST(Estadio estadio) {
		
		estadioService.delete(estadio.getEstadioId());
		return "redirect:/estadio/listar";
	}
	
	
	
	
}
