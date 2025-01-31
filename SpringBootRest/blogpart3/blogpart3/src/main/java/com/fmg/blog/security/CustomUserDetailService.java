package com.fmg.blog.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fmg.blog.entites.User;
import com.fmg.blog.repo.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	private UserRepository userRepository;
	
	

	public CustomUserDetailService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));
        System.out.println(user.getName());
       Set<GrantedAuthority> authorities = user
               .getRoles()
               .stream()
               .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
       System.out.println(authorities.toString());
       return new org.springframework.security.core.userdetails.User(user.getEmail(),
               user.getPassword(),
               authorities);

	}

}
