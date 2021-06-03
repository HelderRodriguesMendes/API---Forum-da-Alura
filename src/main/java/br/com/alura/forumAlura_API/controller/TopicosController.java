package br.com.alura.forumAlura_API.controller;

import br.com.alura.forumAlura_API.controller.dto.TopicoDto;
import br.com.alura.forumAlura_API.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forumAlura_API.controller.form.TopicoForm;
import br.com.alura.forumAlura_API.model.Topico;
import br.com.alura.forumAlura_API.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicosController {

    @Autowired
    TopicoService topicoService;

    @GetMapping("/listar")
    public List<TopicoDto> listar(){
        return topicoService.listar();
    }

    @GetMapping("/pesquisarNome")
    public List<TopicoDto> pesquisar(String nomeCurso){
        return topicoService.pesquisar(nomeCurso);
    }

    @PostMapping("/salvar")
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder){
        Topico topico = topicoService.salvar(topicoForm);
        URI uri = uriBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("detalhar/{id}")
    public DetalhesDoTopicoDto detalhar(@PathVariable Long id){
        return new DetalhesDoTopicoDto(topicoService.detalhar(id));
    }
}
