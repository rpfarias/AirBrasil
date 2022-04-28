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
                .antMatchers(HttpMethod.POST, "/api/users").permitAll()
                .antMatchers(HttpMethod.GET, "/api/routes").permitAll()

                .antMatchers(HttpMethod.POST, "/api/routes/**").hasAnyRole("ADMIN", "THANOS")
                .antMatchers(HttpMethod.PUT, "/api/routes/**").hasAnyRole("ADMIN", "THANOS")
                .antMatchers(HttpMethod.DELETE, "/api/routes/**").hasAnyRole("ADMIN", "THANOS")

                .antMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole("ADMIN", "THANOS")
                .antMatchers(HttpMethod.PUT, "/api/users/**").hasAnyRole("ADMIN", "THANOS")
                .antMatchers(HttpMethod.DELETE, "/api/users/id").hasRole("THANOS")

                .antMatchers(HttpMethod.POST, "/api/roles/**").hasRole("THANOS")
                .antMatchers(HttpMethod.PUT, "/api/roles/**").hasRole("THANOS")
                .antMatchers(HttpMethod.GET, "/api/roles/**").hasAnyRole("ADMIN", "THANOS")
                .antMatchers(HttpMethod.DELETE, "/api/roles/id").hasRole("THANOS")

                .antMatchers(HttpMethod.POST, "/api/tickets").hasAnyRole("ADMIN", "USER", "THANOS")
                .antMatchers(HttpMethod.GET, "/api/tickets/**").hasAnyRole("ADMIN", "THANOS")
                .antMatchers(HttpMethod.PUT, "/api/tickets/**").hasAnyRole("ADMIN", "THANOS")
                .antMatchers(HttpMethod.DELETE, "/api/tickets").hasAnyRole("ADMIN", "USER", "THANOS")
                .antMatchers(HttpMethod.GET, "/api/tickets/passager").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/tickets/cpf").hasRole("USER")
                .anyRequest().authenticated()
                .and().httpBasic();
    }
}
