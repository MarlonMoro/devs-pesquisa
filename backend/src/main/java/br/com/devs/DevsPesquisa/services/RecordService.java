package br.com.devs.DevsPesquisa.services;

import br.com.devs.DevsPesquisa.dto.RecordDTO;
import br.com.devs.DevsPesquisa.dto.RecordInsertDto;
import br.com.devs.DevsPesquisa.entities.Record;
import br.com.devs.DevsPesquisa.repositories.GameRepository;
import br.com.devs.DevsPesquisa.repositories.RecordRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {

  @Autowired
  private RecordRepository recordRepository;
  @Autowired
  private GameRepository gameRepository;

  @Transactional
  public RecordDTO generateRecord(RecordInsertDto recordInsertDto) {

    Record record = recordRepository.save(recordInsertDto.toModel().apply(gameRepository));

    return new RecordDTO(record);
  }


  public Page<RecordDTO> findAll(LocalDateTime minDate, LocalDateTime maxdate,
      PageRequest pageRequest) {

    return recordRepository.findByMomentBetween(minDate, maxdate, pageRequest).map(RecordDTO::new);
  }
}
