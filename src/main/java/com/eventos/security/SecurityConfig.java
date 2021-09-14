package com.eventos.security;

import com.eventos.service.IAdmService;
import com.eventos.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUsuarioService user_serv;

    @Autowired
    private IAdmService adm_serv;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http.cors().and().csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/registration**", "/js/**", "/css/**", "/img/**", "/webjars/**").permitAll()
                .antMatchers("/", "/login", "/cadastre-se", "/cadastre-se/adm", "/cadastre-se/usuario", "/concluir-cadastro/adm", "/concluir-cadastro/usuario", "/eventos", "/sobre").permitAll()
//                .antMatchers("/novo-evento", "/salvar-evento", "/excluir-evento/{idEvt}", "/editar-evento/{idEvt}").hasAuthority("USER").anyRequest()
                .antMatchers("/meus-eventos","/novo-evento", "/salvar-evento", "/excluir-evento/{idEvt}", "/editar-evento/{idEvt}").hasAuthority("ADM").anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .usernameParameter("email")
                .passwordParameter("senha")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(user_serv);
        auth.setUserDetailsService(adm_serv);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


        // CORS Config
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
