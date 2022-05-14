package com.wevibe.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Accesses
        http.authorizeRequests()
                .antMatchers("/","/login", "/register", "/users").permitAll()
                .antMatchers().hasAnyRole("USER_ROLE", "ADMIN_ROLE")
                .anyRequest().authenticated()
                .and();
        // Login Form
        http.formLogin()
//                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("pass")
                .loginProcessingUrl("/home")
                .permitAll()
                .defaultSuccessUrl("/welcome")
                .failureForwardUrl("/login_error")
                .successForwardUrl("/login_success_handler")
                .failureForwardUrl("/login_failure_handler");
        //Logout
        http.logout().permitAll();
    }
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("ROLE_USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }


}