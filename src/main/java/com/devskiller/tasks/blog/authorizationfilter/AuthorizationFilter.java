package com.devskiller.tasks.blog.authorizationfilter;



import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

public class AuthorizationFilter //extends BasicAuthenticationFilter {
{
//	public AuthorizationFilter(AuthenticationManager authenticationManager) {
//		super(authenticationManager);
//	}
//	protected void doInternalFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//     String header=request.getHeader("Authorization");
//	 if(header==null || !header.startsWith("Bearer"))
//	 {
//		 filterChain.doFilter(request,response);
//         return;
//	 }
//		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=getAuthentication(request);
//		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//		filterChain.doFilter(request,response);
//	}
//	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request)
//	{
//		String token = request.getHeader("Authorization");
//		if(token != null)
//		{
//			String user = Jwts.parser().setSigningKey("SecretKeyToGenJWTs".getBytes()).build()
//				.parseClaimsJws(token.replace("Bearer",""))
//				.getBody()
//				.getSubject();
//			if(user != null)
//			{
//				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//			}
//			return null;
//		}
//		return null;
//	}

}
