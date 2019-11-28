package com.moisjmelo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.moisjmelo.entities.User;
import com.moisjmelo.models.UserModel;
import com.moisjmelo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private UserRepository userRepository;
	
//	@RequestMapping(value = "/cadastrarUsuarios", method=RequestMethod.GET)
//	public String form() {
//		return "users/formRegisterUser";
//	}
//	
//	@RequestMapping(value = "/cadastrarUsuarios", method=RequestMethod.POST)
//	public String form(User user) {
//		userRepository.save(user);
//		return "redirect:/cadastrarUsuario";
//	}
	
//	@RequestMapping(value = "/usuarios")
//	public ModelAndView listaUsers() {
//		ModelAndView mv = new ModelAndView("usuarios");
//		Iterable<User> users = userRepository.findAll();
//		mv.addObject("users",users);
//		return mv;
//	}
	
	

}
