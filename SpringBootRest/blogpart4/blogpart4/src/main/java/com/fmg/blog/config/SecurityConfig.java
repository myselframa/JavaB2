package com.fmg.blog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	private UserDetailsService userDetailService;
	
	
	public SecurityConfig(UserDetailsService userDetailService) {
		super();
		this.userDetailService = userDetailService;
	}

	@Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	
	@Bean
	private AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	http.csrf((csrf) -> csrf.disable())
	//.authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated())
	.authorizeHttpRequests(
			(authorize)->authorize.requestMatchers(HttpMethod.GET,"/api/*").permitAll()
			.requestMatchers("/api/auth/**").permitAll()
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
