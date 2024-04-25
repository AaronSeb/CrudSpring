package pe.senati.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pe.senati.service.UserServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	//método de autentificación
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		/*//usuarios en memoria
		auth.inMemoryAuthentication().withUser("rodrigo").password("$2a$10$wy2xJoBfErH.On/riicwPur1floiwXPlAkLh6Bf9SHhetYDYbPR.i").roles("USUARIO");
		auth.inMemoryAuthentication().withUser("juana").password("$2a$10$iqcM04TOqvACucUsuJNGb.BnuaktVRlZctk0UK7JWKf8J2964QO2.").roles("USUARIO");
		auth.inMemoryAuthentication().withUser("andrea").password("$2a$10$Gs9TDOy.K2zAuU/NC8DBM.SSYGSYOgLi.wlG.3e3LdGWvFVMHP7uu").roles("ADMINISTRADOR");
		auth.inMemoryAuthentication().withUser("felipe").password("$2a$10$HJnCuDg/jLcY.jXTJyAxduRBubKtxuvGYQv5cgjRgQRGA8db.rCWC").roles("JEFE","ADMINISTRADOR");
		*/
		
		//autentificación por base de datos
		auth.userDetailsService(userServiceImpl);
	}

	
	//método de autorización
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			
		//permisos URLs
		http.authorizeRequests()
		.antMatchers("/home").permitAll() //todo el mundo puede ver esa URL, autenticados y no autenticados
		.antMatchers("/futbolista/lista").permitAll() //todo el mundo puede ver esa URL, autenticados y no autenticados
		.antMatchers("/club/listar").permitAll() //todo el mundo puede ver esa URL, autenticados y no autenticados
		
		//PERMISOS USUARIOS
		.antMatchers("/liga/listar").access("hasRole('USUARIO') or hasRole('ADMINISTRADOR') or hasRole('JEFE')")
		.antMatchers("/estadistica/listar").access("hasRole('USUARIO') or hasRole('ADMINISTRADOR') or hasRole('JEFE')")
		.antMatchers("/estadio/listar").access("hasRole('USUARIO') or hasRole('ADMINISTRADOR') or hasRole('JEFE')")
		.antMatchers("/club_competicion/listar").access("hasRole('USUARIO') or hasRole('ADMINISTRADOR') or hasRole('JEFE')")
		
		
		//PERMISOS ADMINISTRADOR
		
		.antMatchers("/futbolista/registrar","/futbolista/edita/*").access("hasRole('ADMINISTRADOR')")
		.antMatchers("/liga/registrar","/liga/editar/*").access("hasRole('ADMINISTRADOR')")
		.antMatchers("/club/registrar","/club/editar/*").access("hasRole('ADMINISTRADOR')")
		.antMatchers("/estadistica/registrar","/estadistica/editar/*").access("hasRole('ADMINISTRADOR')")
		.antMatchers("/estadio/registrar","/estadio/editar/*").access("hasRole('ADMINISTRADOR')")
		.antMatchers("/club_competicion/mostrar/*").access("hasRole('ADMINISTRADOR')")
		
		//PERMISOS JEFE
		
		.antMatchers("/futbolista/borrar/*").access("hasRole('JEFE')")
		.antMatchers("/liga/borrar/*").access("hasRole('JEFE')")
		.antMatchers("/club/eliminar/*").access("hasRole('JEFE')")
		.antMatchers("/estadistica/eliminar/*").access("hasRole('JEFE')")
		.antMatchers("/estadio/eliminar/*").access("hasRole('JEFE')");
		
		
			
			
			//login 
			http.authorizeRequests().and()
			.formLogin()
			.loginPage("/login")
			.usernameParameter("txtUsername")
			.passwordParameter("txtPassword")
			.successHandler(customSuccessHandler);
			
			//control de errores
			http.authorizeRequests().and()
			.exceptionHandling().accessDeniedPage("/access_denied");
			
			
			//protección de ataques maliciosos
			http.authorizeRequests().and()
			.csrf();
		}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
