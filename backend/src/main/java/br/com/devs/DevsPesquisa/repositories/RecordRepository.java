package br.com.devs.DevsPesquisa.repositories;

import br.com.devs.DevsPesquisa.entities.Record;
import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {

  Page<Record> findByMomentBetween(LocalDateTime minDate, LocalDateTime maxdate,
      Pageable pageRequest);
}
