package br.com.alura.forumAlura_API.controller;

import br.com.alura.forumAlura_API.controller.form.LoginForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm loginForm){

        System.out.println("email: " + loginForm.getEmail());
        System.out.println("senha: " + loginForm.getSenha());

        return ResponseEntity.ok().build();
    }
}
