package com.rusiruchapana.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(registry->{
                registry.requestMatchers("/home").permitAll();
                registry.requestMatchers("/admin/home").hasRole("ADMIN");
                registry.requestMatchers("/user/home").hasRole("USER");
                registry.anyRequest().authenticated();
        })
                .formLogin(formLogin->{formLogin.permitAll();})
                .build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails normalUser = User.builder()
                .username("rusiru")
                .password("$2a$12$eUWy89tjOy110QWh8N7KgONmS2w4MSR25Z.qezpkxiCT4fBkHDzvW")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("$2a$12$ln0klzRaiGRqZrmbZLW1Qe2G0qNzZI7ltHTkQXSiQlfyumeofUvVC")
                .roles("ADMIN","USER")
                .build();

        return new InMemoryUserDetailsManager(normalUser,admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
