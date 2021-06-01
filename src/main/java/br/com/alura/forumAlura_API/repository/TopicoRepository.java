package br.com.alura.forumAlura_API.repository;

import br.com.alura.forumAlura_API.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
