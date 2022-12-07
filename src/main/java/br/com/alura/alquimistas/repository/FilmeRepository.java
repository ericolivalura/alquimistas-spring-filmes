package br.com.alura.alquimistas.repository;

import br.com.alura.alquimistas.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    Optional<Filme> findByNome(String nome);

    List<Filme> findByGenero(String genero);
}
