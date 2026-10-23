package com.example.baizuhui.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtils {
    private static final String SECRET_KEY = System.getenv().getOrDefault("JWT_SECRET", "change-me-in-local-config");
    private static final long EXPIRATION_TIME = 86400000; // 24小时

    public static String generateToken(Long userId, String openid) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("openid", openid)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}