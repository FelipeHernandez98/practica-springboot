package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
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
	
	@GetMapping({"/index", "/", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "SpringBoot project");
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Felipe");
		usuario.setApellido("Hernandez");
		usuario.setEmail("felipe@hotmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
	
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Caicedo", "andres@gmail.com"),
				new Usuario("Marcos", "Caicedo", "marcos@gmail.com"),
				new Usuario("Angie", "Rodriguez", "angie@gmail.com"));
		
		
		model.addAttribute("titulo", "listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		
		return "listar";
	}
	
}
