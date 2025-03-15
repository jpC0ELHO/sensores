package smarthouse.Sensores.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smarthouse.Sensores.api.dtos.ConfiguracaoRequest;
import smarthouse.Sensores.api.dtos.ConfiguracaoResponse;
import smarthouse.Sensores.api.services.configuracaoService.ConfiguracaoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/configuracao/v1")
@AllArgsConstructor
public class ConfiguracaoController {
    private final ConfiguracaoService configuracaoService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConfiguracaoResponse>>findConfigList(){
        return ResponseEntity.status(HttpStatus.FOUND).body(configuracaoService.findConfigList());
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ConfiguracaoResponse>>findConfigId(@PathVariable UUID uuid){
        return ResponseEntity.status(HttpStatus.FOUND).body(configuracaoService.findConfigId(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createConfig(@RequestBody ConfiguracaoRequest configuracaoRequest){
        configuracaoService.createConfig(configuracaoRequest);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateConfig(@PathVariable UUID uuid,@RequestBody ConfiguracaoRequest configuracaoRequest){
        configuracaoService.updateConfig(uuid,configuracaoRequest);
    }

    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConfig(@PathVariable UUID uuid){
        configuracaoService.deleteConfig(uuid);
    }

}
