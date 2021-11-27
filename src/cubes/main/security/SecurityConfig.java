package cubes.main.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource myDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	UserBuilder users=User.withDefaultPasswordEncoder();
//	auth.inMemoryAuthentication().withUser(users.username("marko").password("marko123").roles("admin"))
//	.withUser(users.username("pera").password("pera123").roles("admin"))
//	.withUser(users.username("jovan").password("jovan123").roles("employee"));
		
		auth.jdbcAuthentication().dataSource(myDataSource);
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	.antMatchers("/").permitAll()
	.antMatchers("/api/**").permitAll()
	.antMatchers("/admin/dist/**").permitAll()
	.antMatchers("/admin/plugins/**").permitAll()
	.antMatchers("/admin/product-list").hasAnyRole("admin,employee")
	.antMatchers("/admin/product-form").hasAnyRole("admin,employee")
	.antMatchers("/admin/category-list").hasAnyRole("admin")
	.antMatchers("/admin/category-form").hasAnyRole("admin")
	.antMatchers("/admin/user-list").hasAnyRole("admin")
	.antMatchers("/admin/user-form").hasAnyRole("admin")
	.antMatchers("/admin/**").hasAnyRole("admin,employee")
	
    .and().formLogin().loginPage("/login-page").loginProcessingUrl("/authenticateTheUser").defaultSuccessUrl("/admin/").permitAll();
	 http.cors().and().csrf().ignoringAntMatchers("/api/**").disable();
	}
}
