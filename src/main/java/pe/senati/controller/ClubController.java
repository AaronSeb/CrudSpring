package pe.senati.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.senati.entity.Club;
import pe.senati.entity.Futbolista;
import pe.senati.service.ClubService;
import pe.senati.service.LigaService;
import pe.senati.service.LigaServiceImpl;

@Controller
@RequestMapping("/club")
public class ClubController {
	
	public ClubController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private ClubService clubService;
	
	@Autowired
	private LigaService ligaService;
	
	@GetMapping("/listar")
	public String listar_GET(Map map) {
		map.put("clubes", clubService.findAll());
		return "Club/listar";
	}
	
	@RequestMapping("/registrar")
	public String registrar_GET(Map map , Model model) {
		
		Club clubNull = new Club();
		model.addAttribute("club", clubNull);
		map.put("bLigas", ligaService.findAll());
		return "Club/registrar";
	}
	
	@PostMapping("/registrar")
	public String registrar_POST(Club club) {
		clubService.insert(club);
		return "redirect:/club/listar";
	}
	
	@GetMapping("/editar/{clubId}")
	public String editar_GET(Map map,Model model, @PathVariable Integer clubId) {
		
		Club clubDb= clubService.findById(clubId);
		model.addAttribute("club", clubDb);
		map.put("bLigas", ligaService.findAll());
		return "Club/editar";
	}
	
	@PostMapping("/editar/{clubId}")
	public String editar_POST(Club club) {
		
		clubService.update(club);
		return "redirect:/club/listar";
	}
	
	@GetMapping("/eliminar/{clubId}")
	public String eliminar_GET(Model model, @PathVariable Integer clubId) {
		
		Club clubDb= clubService.findById(clubId);
		model.addAttribute("club", clubDb);
		return "Club/eliminar";
	}
	
	@PostMapping("/eliminar/{clubId}")
	public String eliminar_POST(Club club) {
		
		clubService.delete(club.getClubId());
		return "redirect:/club/listar";
	}
	
}
