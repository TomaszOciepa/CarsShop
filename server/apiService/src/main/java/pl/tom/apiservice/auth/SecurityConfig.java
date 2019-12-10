package pl.tom.apiservice.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test").permitAll()
                .antMatchers(HttpMethod.PUT, "/update/name/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/update/password/{id}").hasRole("ADMIN")
                .antMatchers("/cars").hasRole("USER")
                .antMatchers("/test2").hasRole("ADMIN")
                .antMatchers("/user/all").hasRole("ADMIN")
                .and()
                .addFilter(new JwtFilter(authenticationManager()));

        http.csrf().disable();
    }
}
