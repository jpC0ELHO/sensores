package smarthouse.Sensores.api.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smarthouse.Sensores.api.dtos.LeituraRequest;
import smarthouse.Sensores.api.dtos.LeituraResponse;
import smarthouse.Sensores.api.services.leituraService.LeituraService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/leitura/v1")
@AllArgsConstructor
public class LeituraController {
    private final LeituraService leituraService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LeituraResponse>>findLeituraList(){
        return ResponseEntity.status(HttpStatus.FOUND).body(leituraService.findLeituraList());
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<LeituraResponse>>findLeituraId(@PathVariable UUID uuid){
        return ResponseEntity.status(HttpStatus.FOUND).body(leituraService.findLeituraId(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createLeitura(@RequestBody LeituraRequest leituraRequest){
        leituraService.createLeitura(leituraRequest);
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateLeitura(@PathVariable UUID uuid, @RequestBody LeituraRequest leituraRequest){
        leituraService.updateLeitura(uuid,leituraRequest);
    }

    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLeitura(@PathVariable UUID uuid){
        leituraService.deleteLeitura(uuid);
    }

}
