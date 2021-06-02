package br.com.alura.forumAlura_API.repository;

import br.com.alura.forumAlura_API.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String nomeCurso);
}
