package ru.boshchenko.rtz_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.boshchenko.rtz_app.security.RtzAuthenticationSuccessHandler;
import ru.boshchenko.rtz_app.security.RtzUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new RtzUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, RtzAuthenticationSuccessHandler successHandler) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/", "main.html",
                                "registration.html", "/api/user/create", "in_development.html",
                                "/css/**", "/js/**", "/imeg/**", "/api/product/all",
                                "main_about_company.html", "main_job_openings.html",
                                "main_products.html").permitAll()

                        .requestMatchers("/client/**").hasRole("USER")
                        .requestMatchers("/manager/**").hasRole("MANAGER")
                        .requestMatchers("/storekeeper/**").hasRole("STOREKEEPER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginProcessingUrl("/login").permitAll().successHandler(successHandler)
                )
                .logout(logout -> logout.logoutSuccessUrl("/main.html").permitAll()
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
