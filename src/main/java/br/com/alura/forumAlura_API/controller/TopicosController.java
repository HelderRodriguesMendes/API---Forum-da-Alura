package br.com.alura.forumAlura_API.controller;

import br.com.alura.forumAlura_API.controller.dto.TopicoDto;
import br.com.alura.forumAlura_API.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forumAlura_API.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forumAlura_API.controller.form.TopicoForm;
import br.com.alura.forumAlura_API.model.Topico;
import br.com.alura.forumAlura_API.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicosController {

    @Autowired
    TopicoService topicoService;

    @GetMapping("/listar")
    public Page<TopicoDto> listar(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        return topicoService.listar(paginacao);
    }

    @GetMapping("/pesquisarNome")
    public Page<TopicoDto> pesquisar(@RequestParam(required = false) String nomeCurso, @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        return topicoService.pesquisar(nomeCurso, paginacao);
    }

    @PostMapping("/salvar")
    @Transactional
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder){
        Topico topico = topicoService.salvar(topicoForm);
        URI uri = uriBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("detalhar/{id}")
    public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id){
        Topico topico = topicoService.detalhar(id);
        if(topico == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new DetalhesDoTopicoDto(topico));
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm atualizacaoTopicoForm){
        Topico topico = topicoService.atualizar(id, atualizacaoTopicoForm);
        if(topico == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new TopicoDto(topico));
    }

    @DeleteMapping("deletar/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Page<TopicoDto> topicoDtos = topicoService.remover(id);

        if(topicoDtos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(topicoDtos);
    }
}
