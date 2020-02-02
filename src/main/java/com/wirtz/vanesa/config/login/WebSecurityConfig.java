package com.wirtz.vanesa.config.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.wirtz.vanesa.negocio.servicios.user.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// Necesario para evitar que la seguridad se aplique a los resources
	// Como los css, imagenes y javascripts
	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.sessionManagement().maximumSessions(100) // (1)
				.maxSessionsPreventsLogin(false) // (2)
				.expiredUrl("/") // (3)
				.sessionRegistry(sessionRegistry()); // (4)

		http.authorizeRequests().antMatchers("/admin*").hasAuthority("admin")
				// .antMatchers("/admin/soloAdmin").hasAuthority("admin")
				.antMatchers("/user*").hasAuthority("user").antMatchers("/**").permitAll().and().formLogin()
				.loginPage("/login").permitAll().defaultSuccessUrl("/").failureUrl("/login?error=true")
				.usernameParameter("username").passwordParameter("password").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
				.exceptionHandling();

	}

	@Bean
	SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public static ServletListenerRegistrationBean httpSessionEventPublisher() { // (5)
		return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
	}

	BCryptPasswordEncoder bCryptPasswordEncoder;

	// Crea el encriptador de contraseñas
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
//El numero 4 representa que tan fuerte quieres la encriptacion.
//Se puede en un rango entre 4 y 31. 
//Si no pones un numero el programa utilizara uno aleatoriamente cada vez
//que inicies la aplicacion, por lo cual tus contrasenas encriptadas no funcionaran bien
		return bCryptPasswordEncoder;
	}

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	// Registra el service para usuarios y el encriptador de contrasena
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// Setting Service to find User in the database.
		// And Setting PassswordEncoder
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		// auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("abc")).roles("ADMIN");
	}

}