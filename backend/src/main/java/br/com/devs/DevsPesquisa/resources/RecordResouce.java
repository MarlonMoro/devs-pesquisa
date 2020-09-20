package br.com.devs.DevsPesquisa.resources;

import br.com.devs.DevsPesquisa.dto.RecordDTO;
import br.com.devs.DevsPesquisa.dto.RecordInsertDto;
import br.com.devs.DevsPesquisa.services.RecordService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping
  public ResponseEntity<Page<RecordDTO>> getAllRecords(
      @RequestParam(value = "min", required = false) String min,
      @RequestParam(value = "max", required = false) String max,
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", required = false) Integer linesPerPage,
      @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
      @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

    LocalDateTime minDate =
        StringUtils.hasText(min) ? LocalDate.parse(min).atStartOfDay() : LocalDate.of(1990, 1, 1).atStartOfDay();
    LocalDateTime maxdate =
        StringUtils.hasText(max) ? LocalDate.parse(max).plusDays(1L).atStartOfDay()
            : LocalDateTime.now();

    PageRequest pageRequest = PageRequest
        .of(page, ObjectUtils.isEmpty(linesPerPage) ? Integer.MAX_VALUE : linesPerPage,
            Direction.valueOf(direction), orderBy);

    return ResponseEntity.ok(recordService.findAll(minDate, maxdate, pageRequest));
  }

}
