package net.javaguides.ems.config;

import net.javaguides.ems.service.UserDetailsServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
// import net.javaguides.ems.filter.JwtAuthenticationFilter;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
        @Autowired
        private UserDetailsServiceImp userDetailsServiceImp;

        @Autowired
        // private JwtAuthenticationFilter jwtAuthenticationFilter;

        // private final CustomLogoutHandler logoutHandler;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                return http
                                .csrf(AbstractHttpConfigurer::disable)
                                .userDetailsService(userDetailsServiceImp)
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                // .addFilterBefore(jwtAuthenticationFilter,
                                // UsernamePasswordAuthenticationFilter.class)
                                // .authorizeHttpRequests(auth -> auth
                                // .requestMatchers("/api/user/login", "/auth/**", "/").permitAll()
                                // .anyRequest().authenticated())
                                .build();

        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
                return configuration.getAuthenticationManager();
        }

}