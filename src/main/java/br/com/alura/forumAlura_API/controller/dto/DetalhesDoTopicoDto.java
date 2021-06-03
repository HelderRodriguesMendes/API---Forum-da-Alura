package br.com.alura.forumAlura_API.controller.dto;


import br.com.alura.forumAlura_API.model.StatusTopico;
import br.com.alura.forumAlura_API.model.Topico;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DetalhesDoTopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopico statusTopico;

    private List<RespostaDTO> respostas;

    public DetalhesDoTopicoDto(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor().getNome();
        this.statusTopico = topico.getStatus();

        this.respostas = new ArrayList<>();
        this.respostas.addAll(topico.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList()));
    }
}
