package com.codeworld.app.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codeworld.app.dto.RegisterRequest;
import com.codeworld.app.exceptions.SpringRedditException;
import com.codeworld.app.model.NotificationEmail;
import com.codeworld.app.model.User;
import com.codeworld.app.model.VerificationToken;
import com.codeworld.app.repository.UserRepository;
import com.codeworld.app.repository.VerificationTokenRepository;

// This contains the main business logic for registering the customer
@Service
public class AuthService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VerificationTokenRepository verificationTokenRepository;
	
	@Autowired
	MailService mailService;
	
	
	public User signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        //user.setPassword(registerRequest.getPassword());
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);

        String token = generateVerificationToken(user);
        
        NotificationEmail  notificationMail = new NotificationEmail("Please Activate your Account",
                user.getEmail(), 
                "Thank you for signing up to Spring Reddit, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8080/api/auth/accountVerification/" + token);
        
        mailService.sendMail(notificationMail);
        
        return user;
    }
	
	private String generateVerificationToken(User user) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUser(user);
		verificationTokenRepository.save(verificationToken);
		return token;
	}
	
	public boolean verifyAccount(String token) {
		Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
		verificationToken.orElseThrow(() -> new SpringRedditException("Invalid token"));
		return fetchUserAndEnable(verificationToken.get());
	}
	
	private boolean fetchUserAndEnable(VerificationToken token) {
		Long user_id = token.getUser().getUserId();
		User user = userRepository.findById(user_id).orElseThrow(()-> new SpringRedditException("User not found"));
		if(user != null) {
			user.setEnabled(true);
			userRepository.save(user);
			return true;
		}else {
			return false;
		}
	}

}
