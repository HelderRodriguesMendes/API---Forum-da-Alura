package br.com.alura.forumAlura_API.controller;

import br.com.alura.forumAlura_API.controller.dto.TopicoDto;
import br.com.alura.forumAlura_API.model.Curso;
import br.com.alura.forumAlura_API.model.Topico;
import br.com.alura.forumAlura_API.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicosController {

    @Autowired
    TopicoRepository topicoRepository;

    @RequestMapping("/listar")
    public List<TopicoDto> listar(){

        List<Topico> topicos = topicoRepository.findAll();
        return TopicoDto.converte(topicos);
    }

    @RequestMapping("/pesquisarNome")
    public List<TopicoDto> pesquisar(String nomeCurso){

        List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
        return TopicoDto.converte(topicos);
    }
}
