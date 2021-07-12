package br.com.alura.forumAlura_API.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //configuracoes de controle de acesso por autenticacao (login)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

    //configuracoes de autoriazacao
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //liberando acesso para os metodos litar e detalhar
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/topico/listar").permitAll()
        .antMatchers(HttpMethod.GET,"/topico/detalhar/*").permitAll()

                .anyRequest().authenticated(); //configurando o acesso dos demais metodos para ser apenas por autenticacao

    }

    //configuracoes de recursos estaticos
    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}
