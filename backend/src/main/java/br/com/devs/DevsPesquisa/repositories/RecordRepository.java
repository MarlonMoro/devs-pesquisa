package br.com.devs.DevsPesquisa.repositories;

import br.com.devs.DevsPesquisa.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {

}
