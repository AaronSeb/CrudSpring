package pe.senati.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.senati.entity.Futbolista;
import pe.senati.service.ClubService;
import pe.senati.service.FutbolistaService;

@Controller
@RequestMapping("/futbolista")
public class FutController {

	public FutController() {
	}
	
	@Autowired
	private FutbolistaService futservice;
	
	@Autowired
	private ClubService clubService;
	
	
	@GetMapping("/lista")
	public String listar_GET(Map map) {
		map.put("jugadores", futservice.findAll());
		return"Futbol/lista";
	}
	// ruta http://localhost:8090/senati/futbolista/lista
	
	
	@GetMapping("/registrar")
	public String registrar_GET(Map map, Model model) {
		
		Futbolista futNull=new Futbolista();
		model.addAttribute("futbolista",futNull);
		map.put("bClubs", clubService.findAll());
		return "Futbol/registra";
	}
	
	@PostMapping("/registrar")
	public String registrar_POST(Futbolista futbolista) {
		futservice.insert(futbolista);
		return "redirect:/futbolista/lista";
	}
	
	@GetMapping("/edita/{id}")
	public String editar_GET(Map map, Model model, @PathVariable Integer id) {
		
		Futbolista futDb= futservice.findById(id);
		model.addAttribute("futbolista",futDb);
		map.put("bClubs", clubService.findAll());
		return "Futbol/editar";
	}
	
	@PostMapping("/edita/{id}")
	public String editar_POST(Futbolista futbolista) {
		//Actualizando en la base de datos
		futservice.update(futbolista);
		return "redirect:/futbolista/lista";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar_GET(Model model,@PathVariable Integer id) {
		
		//empleado cargado
		Futbolista futDb= futservice.findById(id);
		model.addAttribute("futbolista", futDb);
		return "Futbol/borrar";
	}
	
	@PostMapping("/borrar/{id}")
	public String borrar_POST(Futbolista futbolista) {
		futservice.delete(futbolista.getId());
		return "redirect:/futbolista/lista";
	}
	
	
	
}
