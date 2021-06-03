package br.com.alura.forumAlura_API.controller.form;

import br.com.alura.forumAlura_API.model.Curso;
import br.com.alura.forumAlura_API.model.Topico;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TopicoForm {

    @NotEmpty
    @NotNull
    private String titulo;

    @NotEmpty
    @NotNull
    private String mensagem;

    @NotEmpty
    @NotNull
    private String nomeCurso;

    public Topico converter(Curso curso) {
        return new Topico(titulo, mensagem, curso);
    }
}
