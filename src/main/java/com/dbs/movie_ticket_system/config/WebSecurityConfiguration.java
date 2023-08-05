package com.dbs.movie_ticket_system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/json/**", "/css/**", "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/register/**", "/ticketlevels/**", "/seat/**", "/resources/**", "/signup", "/movies/**", "/test/**")
                .permitAll()
                .antMatchers("/customer/**")
                .hasAuthority("CUSTOMER_ROLE")
                .antMatchers("/admin/**")
                .hasAuthority("ADMIN_ROLE")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .successHandler((request, response, authentication) -> {
                    String username = authentication.getName();
                    if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN_ROLE"))) {
                        response.sendRedirect("/admin/"+username+"/home");
                    } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("CUSTOMER_ROLE"))) {
                        response.sendRedirect("/customer/"+username+"/home");
                    }
                })
                .failureUrl("/login?error=true")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID");

    }
}
