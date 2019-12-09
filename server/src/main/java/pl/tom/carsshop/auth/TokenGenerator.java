package pl.tom.carsshop.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import pl.tom.carsshop.model.User;

import java.util.Date;

@Component
public class TokenGenerator {

    public String get(User user){
        long currentTimeMillis = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("roles", user.getRole())
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 60000))
                .signWith(SignatureAlgorithm.HS512, "c=ssTY}wf@u.0qp")
                .compact();
    }

}
