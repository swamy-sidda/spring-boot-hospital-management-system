package hospitalmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import hospitalmanager.security.JwtAuthenticationFilter;

import org.springframework.http.HttpMethod;
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	JwtAuthenticationFilter jwtAuthenticationFilter =
    	        new JwtAuthenticationFilter();

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

            	    .requestMatchers(
            	        "/hospital/auth/login",
            	        "/swagger-ui/**",
            	        "/v3/api-docs/**"
            	    ).permitAll()

            	    .requestMatchers(HttpMethod.POST, "/hospital/users")
            	    .hasRole("ADMIN")

            	    .requestMatchers(HttpMethod.POST, "/hospital/patients")
            	    .hasAnyRole("ADMIN", "PATIENT")

            	    .requestMatchers(HttpMethod.GET, "/hospital/patients/**")
            	    .hasAnyRole("ADMIN", "PATIENT")
            	    
            	    .requestMatchers(HttpMethod.POST, "/hospital/doctors")
            	    .hasRole("ADMIN")

            	    .requestMatchers(HttpMethod.GET, "/hospital/doctors/**")
            	    .hasAnyRole("ADMIN", "PATIENT")
            	    
            	    .requestMatchers(HttpMethod.POST, "/hospital/departments")
            	    .hasRole("ADMIN")

            	    .requestMatchers(HttpMethod.GET, "/hospital/departments/**")
            	    .hasAnyRole("ADMIN", "PATIENT")
            	    
            	    .requestMatchers(HttpMethod.POST, "/hospital/appointments")
            	    .hasAnyRole("ADMIN", "PATIENT")

            	    .requestMatchers(HttpMethod.GET, "/hospital/appointments/**")
            	    .hasAnyRole("ADMIN", "PATIENT")

            	    .anyRequest().authenticated()
            	);
        http.addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
}