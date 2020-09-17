package br.com.devs.DevsPesquisa.repositories;

import br.com.devs.DevsPesquisa.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
