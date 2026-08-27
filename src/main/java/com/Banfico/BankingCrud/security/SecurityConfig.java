package com.Banfico.BankingCrud.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // GET all accounts - JWT required
                        .requestMatchers("/api/accounts").authenticated()

                        // GET account by ID - JWT required
                        .requestMatchers("/api/accounts/*").authenticated()

                        // POST account - admin only
                        .requestMatchers("/api/accounts")
                        .hasRole("admin")

                        // POST transaction - maker only
                        .requestMatchers("/api/accounts/*/transactions")
                        .hasRole("maker")

                        // GET transactions - JWT required
                        .requestMatchers("/api/accounts/*/transactions")
                        .authenticated()

                        // DELETE beneficiary - admin or checker
                        .requestMatchers("/api/beneficiaries/*")
                        .hasAnyRole("admin", "checker")

                        // Other APIs require authentication
                        .anyRequest().authenticated())

                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(new JwtAuthConverter())));

        return http.build();
    }
}