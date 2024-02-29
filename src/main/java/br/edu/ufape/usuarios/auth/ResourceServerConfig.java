package br.edu.ufape.usuarios.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

    private final KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter;

    @Autowired
    public ResourceServerConfig(KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter) {
        this.keycloakJwtAuthenticationConverter = keycloakJwtAuthenticationConverter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        authz -> authz
//                                .requestMatchers("/security/**").permitAll()
//                                .requestMatchers("/api-doc/**").permitAll()
//                                .anyRequest().authenticated()
// quando autenticacao estiver ativar remover a proxima linha e descomentar as outras
                                   .anyRequest().permitAll()
                )
//                .oauth2ResourceServer(oauth2ResourceServer ->
//                        oauth2ResourceServer.jwt((jwt) -> jwt
//                                .jwtAuthenticationConverter(keycloakJwtAuthenticationConverter)
//                        )
//                )
                .cors(Customizer.withDefaults())
        ;
        return http.build();
    }
}
