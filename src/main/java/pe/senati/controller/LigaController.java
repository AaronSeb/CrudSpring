package pe.senati.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.senati.entity.Liga;
import pe.senati.service.LigaService;

@Controller
@RequestMapping("/liga")
public class LigaController {

	@Autowired
	private LigaService ligaservice;
	
	public LigaController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/listar")
	public String listar_GET(Map map){
		map.put("liga", ligaservice.findAll());
		return "Liga/listar";
	}
	
	//url http:localhost:8090/senati/liga/listar
	
	@GetMapping("/registrar")
	public String registrar_GET(Model model) {
		Liga liganull = new Liga();
		model.addAttribute("liga", liganull);
		return "Liga/registrar";
	}
	
	@PostMapping("/registrar")
	public String registrar_POST(Liga liga) {
		ligaservice.insert(liga);
		return "redirect:/liga/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar_GET(Model model,@PathVariable Integer id) {
		
		Liga ligaBd = ligaservice.findById(id);
		model.addAttribute("liga", ligaBd);
		return "Liga/editar";
	}
	
	@PostMapping("/editar/{id}")
	public String editar_POST(Liga liga) {
		ligaservice.update(liga);
		return "redirect:/liga/listar";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar_GET(Model model,@PathVariable Integer id) {
		
		Liga ligaBd = ligaservice.findById(id);
		model.addAttribute("liga", ligaBd);
		return "Liga/borrar";
	}
	
	@PostMapping("/borrar/{id}")
	public String borrar_POST(Liga liga) {
		ligaservice.delete(liga.getLigaId());
		return "redirect:/liga/listar"; 
	}
	
	
	
	
}
