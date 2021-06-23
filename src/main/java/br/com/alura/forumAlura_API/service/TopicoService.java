package br.com.alura.forumAlura_API.service;

import br.com.alura.forumAlura_API.controller.dto.TopicoDto;
import br.com.alura.forumAlura_API.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forumAlura_API.controller.form.TopicoForm;
import br.com.alura.forumAlura_API.model.Curso;
import br.com.alura.forumAlura_API.model.Topico;
import br.com.alura.forumAlura_API.model.Usuario;
import br.com.alura.forumAlura_API.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoService cursoService;

    public Page<TopicoDto> listar(Pageable paginacao){
        Page<Topico> topicos = topicoRepository.findAll(paginacao);

        return TopicoDto.converte(topicos);
    }

    public Page<TopicoDto> pesquisar(String nomeCurso, Pageable paginacao){

        Page<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso, paginacao);
        return TopicoDto.converte(topicos);
    }

    public Topico salvar(TopicoForm topicoForm){
        Curso curso = cursoService.pesquisar_nome(topicoForm.getNomeCurso());
        Topico topico = topicoForm.converter(curso);
        return topicoRepository.save(topico);
    }

    public Topico detalhar(Long id){
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        topicoOptional.get().setAutor(new Usuario());
        if(!topicoOptional.isPresent()){
            return new Topico();
        }
        return topicoOptional.get();
    }

    public Topico atualizar(Long id, AtualizacaoTopicoForm atualizacaoTopicoForm){
        Topico topico = detalhar(id);
        if(topico != null){
            topico.setTitulo(atualizacaoTopicoForm.getTitulo());
            topico.setMensagem(atualizacaoTopicoForm.getMensagem());
        }
        return topico;
    }

    public Page<TopicoDto> remover(Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            topicoRepository.deleteById(id);
            return listar(Pageable.ofSize(10));
        }
        return null;
    }
}
