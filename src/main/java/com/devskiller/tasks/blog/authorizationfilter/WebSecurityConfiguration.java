package com.devskiller.tasks.blog.authorizationfilter;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


//@EnableWebSecurity
public class WebSecurityConfiguration //extends WebSecurityConfigurerAdapter {
{
//{private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	private UserDetailsService userDetailsService;
//	private static final String[] AUTH_WHITELIST = {
//		"/v2/api-docs",
//		"/swagger-resources",
//		"/swagger-resources/**",
//		"/configuration/ui",
//		"/configuration/security",
//		"/swagger-ui.html",
//		"/webjars/**"
//	};
//	public WebSecurityConfiguration(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder)
//	{
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//		this.userDetailsService = userDetailsService;
//	}
//	protected void configure(HttpSecurity httpSecurity) throws Exception
//	{
//		httpSecurity.csrf().disable().authorizeRequests()
//			.antMatchers(AUTH_WHITELIST).permitAll()
//		.antMatchers(HttpMethod.POST, "/api/signup").permitAll()
//		.anyRequest().authenticated()
//		.and().addFilter((Filter) new AuthenticationFilter(authenticationManager()))
//		.addFilter((Filter) new AuthorizationFilter(authenticationManager()))
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}
//	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
//	{
//
//		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//	}
//
//	@Bean
//	CorsConfigurationSource corsConfigurationSource()
//	{
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**",new CorsConfiguration().applyPermitDefaultValues());
//		return source;
//	}
}
