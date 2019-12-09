package pl.tom.carsshop;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.tom.carsshop.auth.JwtFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/cars").hasRole("USER")
                .antMatchers("/test2").hasRole("ADMIN")
                .and()
                .addFilter(new JwtFilter(authenticationManager()));

        http .csrf().disable();

    }
}
