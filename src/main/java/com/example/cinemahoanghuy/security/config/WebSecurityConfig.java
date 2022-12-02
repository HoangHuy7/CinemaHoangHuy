package com.example.cinemahoanghuy.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.*;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,jsr250Enabled = true,securedEnabled = true)
@Configuration

public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager(),getApplicationContext());
        customAuthenticationFilter.setFilterProcessesUrl("/api/v1/login");
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/hello/**").hasAuthority("ADMIN")
                .antMatchers("/api/v1/login/**","/api/v1/authentication/**").permitAll()
                .antMatchers("/api/v1/movies/**","/api/guest/**","/api/v1/branch/**","/api/v1/bill/**",
                        "/api/v1/theater/**","/api/v1/theater/**","/api/v1/room/**","/qr/**").permitAll()
                .anyRequest().
                authenticated()
                .and()
//                .httpBasic()
//                .and()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .addFilter(customAuthenticationFilter);


        http.addFilterBefore(new CustomAuthorizationFilter(getApplicationContext()), UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}
