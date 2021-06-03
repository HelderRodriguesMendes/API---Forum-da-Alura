package br.com.alura.forumAlura_API.exception;

import lombok.Getter;

@Getter
public class ErrodeValidacaoDto {
    private String campo;
    private String erro;

    public ErrodeValidacaoDto(String campoDoErro, String erro) {
        this.campo = campoDoErro;
        this.erro = erro;
    }
}
