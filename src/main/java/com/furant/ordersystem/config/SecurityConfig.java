package com.furant.ordersystem.config;

import com.furant.ordersystem.security.AdminAuthService;
import com.furant.ordersystem.security.AdminUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminAuthService adminAuthService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminAuthService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //配置登录页面
                .formLogin()
                .loginPage("/admin/login")
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                //配置登录权限
                .authorizeRequests()
                .antMatchers("/", "/index","/login","/admin/login","/logout").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //配置登出
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();

        http.csrf().disable();

        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);

        http.addFilterBefore(encodingFilter, CsrfFilter.class);
    }
}
