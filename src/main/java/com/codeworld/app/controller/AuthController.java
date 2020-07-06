package com.codeworld.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeworld.app.dto.RegisterRequest;
import com.codeworld.app.model.User;
import com.codeworld.app.model.VerificationToken;
import com.codeworld.app.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody RegisterRequest request) {
		authService.signup(request);
		return new ResponseEntity<User>(authService.signup(request), HttpStatus.OK);
	}
	
	@GetMapping("accountVerification/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token){
		boolean validatedToken = authService.verifyAccount(token);
		
		if(validatedToken) {
			return new ResponseEntity<String>("Account activated succesfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Account not activated", HttpStatus.NOT_FOUND);
		}
	}

}
