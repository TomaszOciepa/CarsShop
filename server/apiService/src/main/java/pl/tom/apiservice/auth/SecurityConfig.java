package pl.tom.apiservice.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/user/*").hasRole("ADMIN")
                .antMatchers("/car/*").hasRole("ADMIN")
                .and()
                .addFilter(new JwtFilter(authenticationManager()));

        http.csrf().disable();
    }
}
