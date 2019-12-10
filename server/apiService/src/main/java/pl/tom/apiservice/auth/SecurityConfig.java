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
                .antMatchers(HttpMethod.PUT, "/update/name/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/update/password/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/update/role/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/delete/{id}").hasRole("ADMIN")
                .antMatchers( "/user/{id}").hasRole("ADMIN")
                .antMatchers("/user/all").hasRole("ADMIN")
                .antMatchers("/cars").hasRole("USER")
                .and()
                .addFilter(new JwtFilter(authenticationManager()));

        http.csrf().disable();
    }
}
