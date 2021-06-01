package br.com.alura.forumAlura_API.controller.dto;

import br.com.alura.forumAlura_API.model.Topico;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDto(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static List<TopicoDto> converte(List<Topico> topicos) {
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }
}
