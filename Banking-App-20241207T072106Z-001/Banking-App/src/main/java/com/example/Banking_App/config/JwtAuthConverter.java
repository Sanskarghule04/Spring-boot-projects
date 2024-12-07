package com.example.Banking_App.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Override
    public AbstractAuthenticationToken convert(Jwt source) {
        Collection<GrantedAuthority> roles = extractAuthority(source);
        return new JwtAuthenticationToken(source, roles);
    }

    private Collection<GrantedAuthority> extractAuthority(Jwt source){
        if(source.getClaim("realm_access") != null){
            Map<String, Objects> realmAccess = source.getClaim("realm_access");

            ObjectMapper mapper = new ObjectMapper();

            List<String> keyCloakRoles = mapper.convertValue(realmAccess.get("roles"), new TypeReference<List<String>>() {
            });
            List<GrantedAuthority> roles = new ArrayList<>();

            for (String keyCloakRole : keyCloakRoles){
                roles.add(new SimpleGrantedAuthority(keyCloakRole));
            }
            return roles;
        }
        return new ArrayList<>();
    }
}
