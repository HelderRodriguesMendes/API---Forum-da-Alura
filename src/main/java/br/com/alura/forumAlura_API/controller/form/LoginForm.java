package br.com.alura.forumAlura_API.controller.form;

import lombok.Data;

@Data
public class LoginForm {
    private String email;
    private  String senha;
}
