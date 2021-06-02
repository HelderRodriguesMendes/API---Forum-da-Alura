package br.com.alura.forumAlura_API.service;

import br.com.alura.forumAlura_API.model.Curso;
import br.com.alura.forumAlura_API.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public Curso pesquisar_nome(String nomeCurso){
        return cursoRepository.findByNome(nomeCurso);
    }
}
