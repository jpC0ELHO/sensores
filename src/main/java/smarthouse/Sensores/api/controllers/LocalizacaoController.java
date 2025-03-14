package smarthouse.Sensores.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smarthouse.Sensores.api.dtos.LocalizacaoResponse;
import smarthouse.Sensores.api.services.localizacaoService.LocalizacaoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(value = "/localizacao/v1")
@RestController
@AllArgsConstructor
public class LocalizacaoController {
    private final LocalizacaoService localizacaoService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<List<LocalizacaoResponse>>findLocalizacaoList(){
         return ResponseEntity.status(HttpStatus.FOUND).body(localizacaoService.findList());
     }

     @GetMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Optional<LocalizacaoResponse>>findLocalizacaoId(@PathVariable UUID uuid){
        return ResponseEntity.status(HttpStatus.FOUND).body(localizacaoService.findById(uuid));
     }
}
