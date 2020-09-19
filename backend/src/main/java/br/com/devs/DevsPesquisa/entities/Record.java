package br.com.devs.DevsPesquisa.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_record")
public class Record {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Integer age;

  private LocalDateTime moment;

  @ManyToOne
  @JoinColumn(name = "game_id")
  private Game game;

  public Record() {
  }

  public Record(String name, Integer age, Game game) {
    this.name = name;
    this.age = age;
    this.moment = LocalDateTime.now();
    this.game = game;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public LocalDateTime getMoment() {
    return moment;
  }

  public Game getGame() {
    return game;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Record record = (Record) o;
    return id.equals(record.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
