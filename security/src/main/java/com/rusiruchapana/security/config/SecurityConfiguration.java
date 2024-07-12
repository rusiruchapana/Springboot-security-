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
                .password("$2a$10$5Kio.LwpgcsHsJSmGuDcaenu0n/ya/55bA5ZiaHOliwRvm2M9szSm")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("$2a$10$C59dwI9U0/AfosOcR5MwROsHJd729U4l6pr8JcK/cEBXb8Yp4hYam")
                .roles("ADMIN","USER")
                .build();

        return new InMemoryUserDetailsManager(normalUser,admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
