package com.fmg.blog.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fmg.blog.entites.Role;
import com.fmg.blog.entites.User;
import com.fmg.blog.exception.BlogAPIException;
import com.fmg.blog.payloads.LoginDto;
import com.fmg.blog.payloads.RegisterDto;
import com.fmg.blog.repo.RoleRepository;
import com.fmg.blog.repo.UserRepository;
import com.fmg.blog.service.AuthService;
import com.fmg.blog.util.JwtTokenProvider;

@Service
public class AuthServiceImpl implements AuthService{
	
	private AuthenticationManager anuthManager;
	private JwtTokenProvider  jwtTokenProvider ;
	 private AuthenticationManager authenticationManager;
	    private UserRepository userRepository;
	    private RoleRepository roleRepository;
	    private PasswordEncoder passwordEncoder;



	public AuthServiceImpl(AuthenticationManager anuthManager, JwtTokenProvider jwtTokenProvider,
				AuthenticationManager authenticationManager, UserRepository userRepository,
				RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
			super();
			this.anuthManager = anuthManager;
			this.jwtTokenProvider = jwtTokenProvider;
			this.authenticationManager = authenticationManager;
			this.userRepository = userRepository;
			this.roleRepository = roleRepository;
			this.passwordEncoder = passwordEncoder;
		}

	@Override
	    public String login(LoginDto loginDto) {

	        Authentication authentication = anuthManager.authenticate(new UsernamePasswordAuthenticationToken(
	                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        String token = jwtTokenProvider.generateToken(authentication);

	        return token;
	    }

	@Override
	public String register(RegisterDto registerDto) {
		
		if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "User registered successfully!.";
	}

	
	

}
