package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Usuario;
import com.algaworks.festa.repository.UsuarioRepository;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@GetMapping
	public ModelAndView listar(){
		
		ModelAndView view = new ModelAndView("ListaCondidados");
		view.addObject("convidados", usuarioRepository.findAll());
		view.addObject(new Usuario());
		
		return view;
	}
	
	@PostMapping
	public String salvar(Usuario usuario){
		this.usuarioRepository.save(usuario);
		return "redirect:/convidados";
	}
	
}
