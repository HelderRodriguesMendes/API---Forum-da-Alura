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
public class TopicosController {

    @Autowired
    TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(){

        List<Topico> topicos = topicoRepository.findAll();
        return TopicoDto.converte(topicos);
    }
}
