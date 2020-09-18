package br.com.devs.DevsPesquisa.dto;

import br.com.devs.DevsPesquisa.entities.Game;
import br.com.devs.DevsPesquisa.entities.enums.Platform;

public class GameDTO {

  private Long id;
  private String name;
  private Platform platform;

  public GameDTO() {
  }

  public GameDTO(Game game) {
    this.id = game.getId();
    this.name = game.getTitle();
    this.platform = game.getPlataform();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Platform getPlatform() {
    return platform;
  }
}
