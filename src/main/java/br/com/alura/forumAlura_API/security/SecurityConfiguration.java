package br.com.alura.forumAlura_API.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private  AutenticacaoService autenticacaoService;

    //configuracoes de controle de acesso por autenticacao (login)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //indicando qual é a classe que tem a logica de autenticacao
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //configuracoes de autoriazacao
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //liberando acesso para os metodos litar e detalhar
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/topico/listar").permitAll()
        .antMatchers(HttpMethod.GET,"/topico/detalhar/*").permitAll().antMatchers(HttpMethod.POST,"/usuario/cadastrar/*").permitAll()

                //configurando o acesso dos demais metodos para ser apenas por autenticacao
                .anyRequest().authenticated().and().formLogin();

    }

    //configuracoes de recursos estaticos
    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}
