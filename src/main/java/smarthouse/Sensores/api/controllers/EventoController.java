package smarthouse.Sensores.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smarthouse.Sensores.api.dtos.EventoRequest;
import smarthouse.Sensores.api.dtos.EventoResponse;
import smarthouse.Sensores.api.services.eventoService.EventoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/evento/v1")
@AllArgsConstructor
public class EventoController {
    private final EventoService eventoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventoResponse>>findEventoList(){
        return ResponseEntity.status(HttpStatus.FOUND).body(eventoService.findEventoList());
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<EventoResponse>>findEventoById(@PathVariable UUID uuid){
        return ResponseEntity.status(HttpStatus.FOUND).body(eventoService.findEventoId(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvento(@RequestBody EventoRequest eventoRequest){
        eventoService.createEvento(eventoRequest);
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateEvento(@RequestBody EventoRequest eventoRequest,@PathVariable UUID uuid){
        eventoService.updateEvento(uuid,eventoRequest);
    }
    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvento(@PathVariable UUID uuid){
        eventoService.deleteEvento(uuid);
    }
}
