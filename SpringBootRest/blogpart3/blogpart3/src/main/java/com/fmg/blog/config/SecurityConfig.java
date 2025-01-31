package com.fmg.blog.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.fmg.blog.security.CustomUserDetailService;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	
	
	public SecurityConfig(CustomUserDetailService customUserDetailService) {
		super();
		this.customUserDetailService = customUserDetailService;
	}

	@Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	  @Bean
	 public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
	        return configuration.getAuthenticationManager();
	   }

	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	http.csrf((csrf) -> csrf.disable())
	//.authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated())
	.authorizeHttpRequests(
			(authorize)->authorize.requestMatchers(HttpMethod.GET,"/api/*").permitAll()
			//.requestMatchers("/cpmments").authenticated()
			.anyRequest().authenticated())
	.httpBasic(Customizer.withDefaults());
	return http.build();
	}
	
	/*
	 * @Bean public UserDetailsService userDetailsService(){ UserDetails rama =
	 * User.builder() .username("rama") .password(passwordEncoder().encode("rama"))
	 * .roles("USER") .build();
	 * 
	 * UserDetails admin = User.builder() .username("admin")
	 * .password(passwordEncoder().encode("admin")) .roles("ADMIN") .build(); return
	 * new InMemoryUserDetailsManager(rama, admin); }
	 */


}
