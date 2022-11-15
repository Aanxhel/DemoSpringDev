package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping ({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola mundo desde Springboot!");
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setName("Juan");
		usuario.setLastname("Perez");
		model.addAttribute("titulo", "Perfil de usuario: ".concat(usuario.getName()));
		model.addAttribute("usuario", usuario);
		
		return "perfil";
	}
	
	@GetMapping("/listar")
		public String listar(Model model) {
		List<Usuario> usuario = Arrays.asList(
				new Usuario("alfa","bravp","charly"),
				new Usuario("delta","eco","fox")
				);
		
		model.addAttribute("usuario", usuario);
		return "listar";
	}
		
	

}
