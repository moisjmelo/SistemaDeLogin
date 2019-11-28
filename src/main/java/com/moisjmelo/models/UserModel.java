package com.moisjmelo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.moisjmelo.entities.User;
import com.moisjmelo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserModel {
	
	@Autowired
	private UserService service;
	
	
	@RequestMapping(value = "/cadastrarUsuarios", method=RequestMethod.GET)
	public String form() {
		return "users/formRegisterUser";
	}
	
	@RequestMapping(value = "/cadastrarUsuarios", method=RequestMethod.POST)
	public String form(User user) {
		service.insert(user);
		return "redirect:/cadastrarUsuario";
	}
	
	@RequestMapping(value = "/usuarios")
	public ModelAndView listaUsers() {
		ModelAndView mv = new ModelAndView("usuarios");
		Iterable<User> users = service.findAll();
		mv.addObject("users",users);
		return mv;
	}
	
	
//	@GetMapping
//	public ResponseEntity<List<User>> findAll(){
//		List<User> list = service.findAll();
//		return ResponseEntity.ok().body(list);
//		
//	}
//	
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<User> findById(@PathVariable Long id){
//		User obj = service.findById(id);
//		return ResponseEntity.ok(obj);
//		
//	}
//	
//	@PostMapping
//	public ResponseEntity<User> insert(@RequestBody User obj){
//		obj = service.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).body(obj);
//	}
//	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> delete(@PathVariable Long id){
//		service.delete(id);
//		return ResponseEntity.noContent().build();		
//	}
//	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
//		obj = service.update(id, obj);
//		return ResponseEntity.ok().body(obj);
//	}

}

