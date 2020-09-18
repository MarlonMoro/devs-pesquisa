package br.com.devs.DevsPesquisa.resources;

import br.com.devs.DevsPesquisa.dto.GameDTO;
import br.com.devs.DevsPesquisa.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/games")
public class GameController {


  @Autowired
  private GameService gameService;

  @GetMapping
  public ResponseEntity<List<GameDTO>> getAllGames() {
    return ResponseEntity.ok(gameService.getAllGames());
  }

}
