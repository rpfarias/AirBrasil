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
/*                .antMatchers(HttpMethod.GET, "/api/clients/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/client/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/client/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/client/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/client/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/destinies/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/destiny/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/destiny/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/destiny/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/destiny/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/reservations/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/reservation/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/reservation/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/reservation/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/reservation/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/ticket/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/tickets").permitAll()
                .antMatchers(HttpMethod.GET, "/api/ticket/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/ticket/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/ticket/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/tickets/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/ticket/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/client/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/api/client/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/destinies/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/destiny/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/reservation/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/reservation/**").hasRole("USER")*/
                .antMatchers("/api/users/**").permitAll()
                .anyRequest().permitAll()
                .and().httpBasic();
    }
}
