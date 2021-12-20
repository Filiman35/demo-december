package december.christmas.demo.configuration;

import december.christmas.demo.configuration.enums.Permission;
import december.christmas.demo.configuration.enums.SecurityRoles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http
//        .csrf().disable()
//        .authorizeRequests()
//        .antMatchers("/").permitAll()
//        .antMatchers("/api/v1").permitAll()
//        .antMatchers(HttpMethod.GET, "/home").hasAnyRole(SecurityRoles.ADMIN.name(), SecurityRoles.MANAGER.name(), SecurityRoles.USER.name())
//        .antMatchers(HttpMethod.GET, "/logout").hasAnyRole(SecurityRoles.ADMIN.name(), SecurityRoles.MANAGER.name(), SecurityRoles.USER.name())
//        .antMatchers(HttpMethod.GET, "/my-profile").hasRole(SecurityRoles.ADMIN.name())
//        .anyRequest()
//        .authenticated()
//        .and()
//        .httpBasic();
//  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http
//        .csrf().disable()
//        .authorizeRequests()
//        .antMatchers("/").permitAll()
//        .antMatchers("/api/v1").permitAll()
//        .antMatchers(HttpMethod.GET, "/home").hasAuthority(Permission.READ.getPermission())
//        .antMatchers(HttpMethod.GET, "/logout").hasAuthority(Permission.READ.getPermission())
//        .antMatchers(HttpMethod.GET, "/my-profile").hasAuthority(Permission.WRITE.getPermission())
//        .anyRequest()
//        .authenticated()
//        .and()
//        .httpBasic();
//  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/api/v1").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }


//  @Bean
//  @Override
//  protected UserDetailsService userDetailsService() {
//    List<UserDetails> userDetailsList = new ArrayList<>();
//    userDetailsList.add(User.withUsername("admin").password(passwordEncoder().encode("admin"))
//        .roles(SecurityRoles.ADMIN.name(), SecurityRoles.USER.name()).build());
//    userDetailsList.add(User.withUsername("manager").password(passwordEncoder().encode("manager"))
//        .roles(SecurityRoles.MANAGER.name(), SecurityRoles.USER.name()).build());
//    userDetailsList.add(User.withUsername("user").password(passwordEncoder().encode("user"))
//        .roles(SecurityRoles.USER.name()).build());
//
//    return new InMemoryUserDetailsManager(userDetailsList);
//  }

  @Bean
  @Override
  protected UserDetailsService userDetailsService() {
    List<UserDetails> userDetailsList = new ArrayList<>();
    userDetailsList.add(User.withUsername("admin").password(passwordEncoder().encode("admin"))
        .authorities(SecurityRoles.ADMIN.getAuthorities()).build());
    userDetailsList.add(User.withUsername("manager").password(passwordEncoder().encode("manager"))
        .authorities(SecurityRoles.MANAGER.getAuthorities()).build());
    userDetailsList.add(User.withUsername("user").password(passwordEncoder().encode("user"))
        .authorities(SecurityRoles.USER.getAuthorities()).build());

    return new InMemoryUserDetailsManager(userDetailsList);
  }

  @Bean
  public PasswordEncoder passwordEncoder()
  {
    return new BCryptPasswordEncoder();
  }


}
