package com.shoppingapp.DylanStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.shoppingapp.DylanStore.auth.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
        @Bean
        public UserDetailsService userDetailsService() {
                return new CustomUserDetailsService();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
        @Bean
        public DaoAuthenticationProvider authenticationProvider(){
            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
            authenticationProvider.setUserDetailsService(userDetailsService());
            authenticationProvider.setPasswordEncoder(passwordEncoder());
            return authenticationProvider;
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/","/register", "/vendor/**","/static/**", "/css/**", "/js/**", "/images/**", "/fonts/**").permitAll()
                    .anyRequest().authenticated()
                )
                .formLogin(form -> form
                    .loginPage("/login")
                    .usernameParameter("your_email")
                    .passwordParameter("your_pass")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error=true")
                    .permitAll()
                )
                .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .permitAll()
                );
    
            return http.build();
        }

        
        protected void configure(AuthenticationManagerBuilder auth) throws Exception{
            auth.authenticationProvider(authenticationProvider());
        }

        
}
