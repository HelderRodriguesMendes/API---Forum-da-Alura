package br.com.alura.forumAlura_API.controller.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AtualizacaoTopicoForm {

    @NotEmpty
    @NotNull
    private String titulo;

    @NotEmpty
    @NotNull
    private String mensagem;
}
