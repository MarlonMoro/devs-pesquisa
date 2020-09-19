package br.com.devs.DevsPesquisa.resources;

import br.com.devs.DevsPesquisa.dto.RecordDTO;
import br.com.devs.DevsPesquisa.dto.RecordInsertDto;
import br.com.devs.DevsPesquisa.services.RecordService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/records")
public class RecordResouce {

  @Autowired
  private RecordService recordService;

  @PostMapping
  public ResponseEntity<RecordDTO> saveRecord(@RequestBody @Valid RecordInsertDto recordInsertDto) {

    return ResponseEntity.ok(recordService.generateRecord(recordInsertDto));
  }

}
