package br.com.devs.DevsPesquisa.dto;

import br.com.devs.DevsPesquisa.entities.Record;
import br.com.devs.DevsPesquisa.entities.enums.Platform;
import java.time.LocalDateTime;

public class RecordDTO {

  private Long id;
  private LocalDateTime moment;
  private String name;
  private Integer age;
  private String gameTitle;
  private Platform gamePlatform;
  private String genreName;

  public RecordDTO() {
  }

  public RecordDTO(Record record) {
    this.id = record.getId();
    this.moment = record.getMoment();
    this.name = record.getName();
    this.age = record.getAge();
    this.gameTitle = record.getGame().getTitle();
    this.gamePlatform = record.getGame().getPlataform();
    this.genreName = record.getGame().getGenre().getName();
  }

  public Long getId() {
    return id;
  }

  public LocalDateTime getMoment() {
    return moment;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String getGameTitle() {
    return gameTitle;
  }

  public Platform getGamePlatform() {
    return gamePlatform;
  }

  public String getGenreName() {
    return genreName;
  }
}
