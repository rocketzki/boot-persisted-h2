package com.rocketzki.persistedh2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecuritySettings extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.auth-query}")
    private String authQuery;

    @Autowired
    public SecuritySettings(DataSource ds) {
        this.dataSource = ds;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(authQuery)
                .dataSource(dataSource)
                .passwordEncoder(passEncrypt());
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/laptops").hasAnyAuthority("SUPERUSER", "ADMIN")
                .antMatchers("/h2/**").hasAuthority("ADMIN")
                .and()
                .headers().frameOptions().disable()
                .and()
                .logout();
    }

    @Bean
    public PasswordEncoder passEncrypt() {
        return new BCryptPasswordEncoder();
    }
}