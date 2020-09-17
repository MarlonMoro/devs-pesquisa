package br.com.devs.DevsPesquisa.repositories;

import br.com.devs.DevsPesquisa.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
