package br.com.devs.DevsPesquisa.services;

import br.com.devs.DevsPesquisa.dto.RecordDTO;
import br.com.devs.DevsPesquisa.dto.RecordInsertDto;
import br.com.devs.DevsPesquisa.entities.Record;
import br.com.devs.DevsPesquisa.repositories.GameRepository;
import br.com.devs.DevsPesquisa.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


}
