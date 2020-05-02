package com.codeworld.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codeworld.app.DAO.UserRepositoryDAO;
import com.codeworld.app.entity.User;
import com.codeworld.app.models.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
    UserRepositoryDAO userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName)); //throwing the exception mentioned as throws above
        return user.map(MyUserDetails::new).get();
        // Getting the user from the database, converting into a MyUserDetails instance and returning it
	}

}
