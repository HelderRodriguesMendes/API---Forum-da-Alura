package br.com.alura.forumAlura_API.service;

import br.com.alura.forumAlura_API.controller.dto.TopicoDto;
import br.com.alura.forumAlura_API.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forumAlura_API.controller.form.TopicoForm;
import br.com.alura.forumAlura_API.model.Curso;
import br.com.alura.forumAlura_API.model.Topico;
import br.com.alura.forumAlura_API.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<TopicoDto> listar(){
        List<Topico> topicos = topicoRepository.findAll();
        return TopicoDto.converte(topicos);
    }

    public List<TopicoDto> pesquisar(String nomeCurso){

        List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
        return TopicoDto.converte(topicos);
    }

    public Topico salvar(TopicoForm topicoForm){
        Curso curso = cursoService.pesquisar_nome(topicoForm.getNomeCurso());
        Topico topico = topicoForm.converter(curso);
        return topicoRepository.save(topico);
    }

    public Topico detalhar(Long id){
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if(!topicoOptional.isPresent()){
            return null;
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

    public List<TopicoDto> remover(Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            topicoRepository.deleteById(id);
            return listar();
        }
        return new ArrayList<>();
    }
}
