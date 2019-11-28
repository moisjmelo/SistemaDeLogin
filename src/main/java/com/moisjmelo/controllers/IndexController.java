package com.moisjmelo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.moisjmelo.entities.User;
import com.moisjmelo.repositories.UserRepository;

@Controller
public class IndexController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String index() {		
		return "index";
	}
	
//	@RequestMapping("/usuarios")
//	public String usuarios() {		
//		return "users/usuarios";
//	}
//	
//	@RequestMapping("/cadastrarUsuario")
//	public String cadastrar() {		
//		return "users/formRegisterUser";
//	}
	
	@RequestMapping(value = "/cadastrarUsuario", method=RequestMethod.GET)
	public String form() {
		return "users/formRegisterUser";
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method=RequestMethod.POST)
	public String form(User user) {
		userRepository.save(user);
		return "redirect:/cadastrarUsuario";
	}
	
	@RequestMapping(value = "/usuarios")
	public ModelAndView listaUsers() {
		ModelAndView mv = new ModelAndView("usuarios");
		Iterable<User> users = userRepository.findAll();
		mv.addObject("users",users);
		return mv;
	}

}
