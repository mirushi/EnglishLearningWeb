package com.comittedpeople.englishlearningweb.jwt;


import java.util.Date;

import org.springframework.stereotype.Component;

import com.comittedpeople.englishlearningweb.domain.UserDetailsCustom;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	private final String JWT_SECRET = "committedpeople";
	
	private final long JWT_EXPIRATION = 604800000L;
	
	public String generateToken (UserDetailsCustom userDetails) {
		Date now = new Date();
		
		Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
		
		return Jwts.builder()
				.setSubject(Long.toString(userDetails.getUseraccount().getId()))
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
				.compact();
	}
	
	public Long getUserIdFromJWT (String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(JWT_SECRET)
				.parseClaimsJws(token)
				.getBody();
		
		return Long.parseLong(claims.getSubject());
	}
	
	public boolean validateToken (String authToken) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
			return true;
		}catch (MalformedJwtException e) {
			// TODO: handle exception
			System.out.println("Malformed JWT");
		}catch (ExpiredJwtException e) {
			// TODO: handle exception
			System.out.println("Token expired");
		}catch (UnsupportedJwtException e) {
			// TODO: handle exception
			System.out.println("Unsupported JWT Token");
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println("JWT claims string is empty");
		}
		return false;
	}
	
}
