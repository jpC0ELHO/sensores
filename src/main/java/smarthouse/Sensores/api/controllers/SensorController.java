package smarthouse.Sensores.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smarthouse.Sensores.api.dtos.SensorRequest;
import smarthouse.Sensores.api.dtos.SensorResponse;
import smarthouse.Sensores.api.services.sensorService.SensorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(value = "/sensor/v1")
@RestController
@AllArgsConstructor
public class SensorController {
    private final SensorService sensorService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SensorResponse>>findSensorList(){
        return ResponseEntity.status(HttpStatus.FOUND).body(sensorService.findSensorList());
    }

    @GetMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<SensorResponse>>findSensorId(@PathVariable UUID uuid){
        return ResponseEntity.status(HttpStatus.FOUND).body(sensorService.findSensorId(uuid));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createSensor(@RequestBody SensorRequest sensorRequest){
        sensorService.createSensor(sensorRequest);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateSensor(@PathVariable UUID uuid, @RequestBody SensorRequest sensorRequest){
        sensorService.updateSensor(uuid,sensorRequest);
    }

    @DeleteMapping(value = "/{d}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSensor(@PathVariable UUID uuid){
        sensorService.deleteSensor(uuid);
    }
}
