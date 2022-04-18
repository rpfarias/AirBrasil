package com.airbrasil.apirest.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailConfiguration userDetailConfiguration;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailConfiguration).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/swagger-ui/index.html", "/v2/api-docs", "/swagger-resources/**", "/webjars/**", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable();
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/destinies/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/destiny/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/destiny/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/destiny/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/destiny/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/users").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/tickets/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/tickets").permitAll()
                .antMatchers(HttpMethod.GET, "/api/tickets/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/tickets/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/tickets/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/tickets/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/tickets/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/tickets/origin").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/tickets/destiny").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/destinies/**").hasRole("USER")
                .and().httpBasic();
    }
}
