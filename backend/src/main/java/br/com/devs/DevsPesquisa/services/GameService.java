package br.com.devs.DevsPesquisa.services;

import br.com.devs.DevsPesquisa.dto.GameDTO;
import br.com.devs.DevsPesquisa.repositories.GameRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;


  public List<GameDTO> getAllGames() {
    return gameRepository.findAll().stream().map(GameDTO::new).collect(Collectors.toList());
  }

}
