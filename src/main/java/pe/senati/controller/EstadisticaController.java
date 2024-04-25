package pe.senati.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.senati.entity.Estadistica;
import pe.senati.service.EstadisticaService;
import pe.senati.service.FutbolistaService;

@Controller
@RequestMapping("/estadistica")
public class EstadisticaController {
	
	public EstadisticaController() {
		
	}
	@Autowired
	private EstadisticaService estadisticaService;
	
	@Autowired
	private FutbolistaService futbolistaService;
	
	
	
	@GetMapping("/listar")
	public String listar_GET(Map map) {
		map.put("estadisticas",estadisticaService.findAll());
		return "Estadistica/listar";
	}
	
	
	@GetMapping("/registrar")
	public String registrar_GET(Model model, Map map) {
		
		Estadistica estadisticaNull=new Estadistica();
		model.addAttribute("estadistica",estadisticaNull);
		map.put("bFutbolistas", futbolistaService.findAll());
		return "Estadistica/registrar";
	}
	
	@PostMapping("/registrar")
	public String registrar_POST(Estadistica estadistica) {
		estadisticaService.insert(estadistica);
		return "redirect:/estadistica/listar";
	}
	
	@GetMapping("/editar/{estadisticaId}")
	public String editar_GET(Map map,Model model, @PathVariable Integer estadisticaId) {
		
		Estadistica estadisticaDb= estadisticaService.findById(estadisticaId);
		model.addAttribute("estadistica", estadisticaDb);
		map.put("bFutbolistas", futbolistaService.findAll());
		return "Estadistica/editar";
	}
	
	@PostMapping("/editar/{estadisticaId}")
	public String editar_POST(Estadistica estadistica) {
		
		estadisticaService.update(estadistica);
		return "redirect:/estadistica/listar";
	}
	
	@GetMapping("/eliminar/{estadisticaId}")
	public String eliminar_GET(Model model, @PathVariable Integer estadisticaId) {
		
		Estadistica estadisticaDb= estadisticaService.findById(estadisticaId);
		model.addAttribute("estadistica", estadisticaDb);
		return "Estadistica/eliminar";
	}
	
	@PostMapping("/eliminar/{estadisticaId}")
	public String eliminar_POST(Estadistica estadistica) {
		
		estadisticaService.delete(estadistica.getEstadisticaId());
		return "redirect:/estadistica/listar";
	}
	
	
}
