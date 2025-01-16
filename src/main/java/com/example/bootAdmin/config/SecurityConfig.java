package com.example.bootAdmin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests( authorize ->
                authorize.requestMatchers("/").authenticated()
                        .requestMatchers("/login").permitAll() //로그인화면
                        .requestMatchers("/wallboard").authenticated() //대시보드
                        .requestMatchers("/application").authenticated() //애플리케이션
                        .requestMatchers("/journal").authenticated() //일지
                        .anyRequest().permitAll()
        );

        http.formLogin(form->form.loginPage("/login"));
//        http.logout(form->form.logoutUrl("/login"));
        return http.build();
    }
}
