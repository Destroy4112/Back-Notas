package com.zaperoko.notas.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    public static final String KEYWORD = "PALABRACLAVE";

    public String generarToken(String usuario, String rol) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("SCOPED_rol" + rol);
        String token = Jwts.builder()
                .setId("jwt" + usuario)
                .claim("usuario", usuario)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1800000)) //1800000   10000
                .signWith(SignatureAlgorithm.HS512, KEYWORD.getBytes())
                .compact();

        return token;
    }
}
