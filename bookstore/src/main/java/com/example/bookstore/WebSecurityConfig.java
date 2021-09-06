package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.bookstore.service.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserService userDetailsService;	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	.antMatchers("/css/*", "/img/*").permitAll()
            	.anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index.html", true)
                .permitAll()
                .and()
                .httpBasic()
    			.and()
    			.csrf().disable()
    		.logout()
    			.logoutSuccessUrl("/login")
    			.invalidateHttpSession(true)
    			.deleteCookies("JSESSIONID");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /* inMemoryAuthentication no longer in use
    	auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
        auth
        	.inMemoryAuthentication()
            	.withUser("admin").password("password").roles("ADMIN");
        */
    	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}