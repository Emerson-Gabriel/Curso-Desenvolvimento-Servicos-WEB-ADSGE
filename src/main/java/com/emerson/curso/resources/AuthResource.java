package com.emerson.curso.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emerson.curso.dto.CredentialsDTO;
import com.emerson.curso.dto.TokenDTO;
import com.emerson.curso.services.AuthService;

@RestController
@RequestMapping(value="/auth")
public class AuthResource {

	@Autowired
	private AuthService service;


	@PostMapping("/login")
	public ResponseEntity<TokenDTO> login(@RequestBody CredentialsDTO dto){
		TokenDTO tokenDto= service.authenticate(dto);

		return ResponseEntity.ok().body(tokenDto);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<TokenDTO> refresh(){
		TokenDTO tokenDto= service.refreshToken();

		return ResponseEntity.ok().body(tokenDto);
	}
	
}
