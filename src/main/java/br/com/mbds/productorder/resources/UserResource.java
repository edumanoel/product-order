package br.com.mbds.productorder.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mbds.productorder.entities.User;

@RestController

@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		return ResponseEntity.ok().body(User.builder()
				.id(1L)
				.name("Test User")
				.build());
	}

}
