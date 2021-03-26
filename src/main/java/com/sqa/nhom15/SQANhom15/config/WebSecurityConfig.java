package com.sqa.nhom15.SQANhom15.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/js/**", "/css/**").permitAll()
                .antMatchers("/monhoc/INT1408/**").hasAnyRole("TEACHERINT1408", "ADMIN")
                .antMatchers("/monhoc/INT1416/**").hasAnyRole("TEACHERINT1416", "ADMIN")
                .antMatchers("/monhoc/INT1427/**").hasAnyRole("TEACHERINT1427", "ADMIN")
                .antMatchers("/cauhinh/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateUser").permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                .deleteCookies("JSESSIONID")
                .and()
                .rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400)
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

}

