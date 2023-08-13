package blog.main.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource myDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 
		auth.jdbcAuthentication().dataSource(myDataSource);
		 
	}
	 
	
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		 
		http.authorizeRequests().
		antMatchers("/").permitAll().
		antMatchers("/admin/css/**").permitAll().
		antMatchers("/admin/img/**").permitAll().
		antMatchers("/admin/js/**").permitAll().
		antMatchers("/admin/less/**").permitAll().
		antMatchers("/front/**").permitAll().
		antMatchers("/admin/**").hasAnyRole("admin","user").
		antMatchers("/images/**").permitAll().
		antMatchers(HttpMethod.POST,"/admin/save-image").hasAnyRole("admin","user").
		antMatchers(HttpMethod.GET,"/**").permitAll().
		and().
 		logout().
 		logoutUrl("/logout").
		logoutSuccessUrl("/login").permitAll().
		and().
		formLogin().loginPage("/login").
		loginProcessingUrl("/authenticateTheUser").
		permitAll().
		and().
		cors().
		and().
		csrf().disable();
		
		 
    }
	 
 
}
