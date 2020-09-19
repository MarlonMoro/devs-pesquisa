package br.com.devs.DevsPesquisa.dto;

import br.com.devs.DevsPesquisa.entities.Game;
import br.com.devs.DevsPesquisa.entities.Record;
import br.com.devs.DevsPesquisa.repositories.GameRepository;
import java.util.function.Function;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RecordInsertDto {

  @NotBlank
  private String name;
  @NotNull
  private Integer age;
  @NotNull
  private Long gameId;

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Long getGameId() {
    return gameId;
  }

  public Function<GameRepository, Record> toModel(){
    return (gameRepository -> {
      Game game = gameRepository.findById(this.getGameId()).orElseThrow();
      return new Record(this.getName(), this.getAge(), game);
    });
  }
}
