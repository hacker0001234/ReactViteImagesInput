package com.example.aplicationTest.Configs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CookieCsrfTokenRepository tokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        tokenRepository.setCookieCustomizer(cookie -> {
            cookie.secure(false);
            cookie.sameSite("Lax");
        });

        http
                .csrf(csrf -> csrf
                .csrfTokenRepository(tokenRepository)
                )

                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }
}

