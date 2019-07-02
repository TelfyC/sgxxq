package com.hydx.util;

import com.auth0.jwt.JWT;
import com.hydx.pojo.Manage;
import com.hydx.pojo.User;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtUtils {
    static final private String KEY = "cba5b953-514c-42db-997c-dea1c5d9e9d7";

    public String getToken(User user) {
        if (user != null) {
            JwtBuilder jwtBuilder = Jwts.builder().setId(user.getU_id() + "").setSubject(user.getU_name())
                    .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + (60 * 1000 * 60 * 24 * 7)))
                    .signWith(SignatureAlgorithm.HS256, KEY.getBytes());
            return jwtBuilder.compact();
        }
        return "";
    }

    public String getToken(Manage manage) {
        if (manage != null) {
            Map<String, Object> chaims = new HashMap<String, Object>();
            chaims.put("grade", manage.getM_grade());
            JwtBuilder jwtBuilder = Jwts.builder().setClaims(chaims).setId(manage.getM_id() + "").setSubject(manage.getM_name())
                    .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + (60 * 1000 * 60 * 24 * 7)))
                    .signWith(SignatureAlgorithm.HS256, KEY.getBytes());
            //System.out.println(jwtBuilder.compact());
            return jwtBuilder.compact();
        }
        return "";
    }

    static public Boolean isVerify(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(KEY.getBytes()).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println(claims.getExpiration());
        return true;
    }

    static public Boolean isAdmin(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(KEY.getBytes()).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            return false;
        }
        //String  s = ;
        if(claims.get("grade") != null)
            return true;
        //System.out.println();
        return false;
    }
}
