package br.com.alura.forumAlura_API.repository;

import br.com.alura.forumAlura_API.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    //pesquisa por um atributo que é de uma classe de relacionamento
    List<Topico> findByCursoNome(String nomeCurso);
}
