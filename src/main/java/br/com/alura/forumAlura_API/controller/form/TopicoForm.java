package br.com.alura.forumAlura_API.controller.form;

import br.com.alura.forumAlura_API.model.Curso;
import br.com.alura.forumAlura_API.model.Topico;
import lombok.Data;

@Data
public class TopicoForm {

    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public Topico converter(Curso curso) {
        return new Topico(titulo, mensagem, curso);
    }
}
