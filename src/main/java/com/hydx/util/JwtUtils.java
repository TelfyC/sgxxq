package com.hydx.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.hydx.pojo.User;
import io.jsonwebtoken.*;

import java.util.Date;


public class JwtUtils {
    static final String KEY = "cba5b953-514c-42db-997c-dea1c5d9e9d7";

    public String getToken(User user) {
        if (user != null) {
            /*String token = "";
            token = JWT.create().withAudience(user.getU_name()).sign(Algorithm.HMAC256(KEY));
            System.out.println(token);
            return token;*/
            JwtBuilder jwtBuilder = Jwts.builder().setId(user.getU_id() + "").setSubject(user.getU_name())
                    .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + (60 * 1000 * 60 * 24*7)))
                    .signWith(SignatureAlgorithm.HS256, KEY.getBytes());
            return jwtBuilder.compact();
        }
        return "";
    }

    public Boolean isVerify(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(KEY.getBytes()).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println(claims.getExpiration());
        return true;
    }

}
