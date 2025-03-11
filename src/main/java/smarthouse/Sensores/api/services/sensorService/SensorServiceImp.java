package smarthouse.Sensores.api.services.sensorService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import smarthouse.Sensores.api.dtos.SensorRequest;
import smarthouse.Sensores.api.dtos.SensorResponse;
import smarthouse.Sensores.domain.exceptions.ModelIntegrityViolationException;
import smarthouse.Sensores.domain.exceptions.ModelNotFoundException;
import smarthouse.Sensores.domain.repositories.SensorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static smarthouse.Sensores.api.dtos.SensorRequest.toEntidade;

@AllArgsConstructor
@Log4j2
@Service
public class SensorServiceImp implements SensorService{
    private final SensorRepository sensorRepository;
    @Override
    public List<SensorResponse> findSensorList() {
        try{
            var findSensorList=sensorRepository.findAll();
            if (findSensorList.isEmpty()){
                throw new ModelNotFoundException("Sensor not found!");
            }
            return findSensorList.stream().map(SensorResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error: {} !",e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<SensorResponse> findSensorId(UUID uuid) {
        var findSensorId=sensorRepository.findSensorByID(uuid);
        if (findSensorId.isEmpty()){
            throw new ModelNotFoundException("ID not found!");
        }
        return findSensorId.map(SensorResponse::toResponse);
    }

    @Override
    public void createSensor(SensorRequest sensorRequest) {
        var findSensorByRegiao=sensorRepository.findByRegiao(sensorRequest.regiao());
        var findSensorByTipo=sensorRepository.findBySensorTipo(sensorRequest.sensorTipo());
        if (findSensorByTipo.isPresent()&&findSensorByRegiao.isPresent()){
            throw new ModelIntegrityViolationException("Sensor already exists! Description: "
                    +sensorRequest.regiao()+" Type: "+sensorRequest.sensorTipo());
        }
        sensorRepository.save(toEntidade(sensorRequest));
    }

    @Override
    public void updateSensor(UUID uuid, SensorRequest sensorRequest) {
        var findById=sensorRepository.findSensorByID(uuid);
        if (findById.isEmpty()){
            log.error("ID: {} not found!",uuid);
            throw new ModelNotFoundException("Not found!");
        }
            findById.map(sensor -> {
            sensor.setName(sensorRequest.name());
            sensor.setLocalizacao(sensorRequest.localizacao());
            sensor.setSensorTipo(sensorRequest.sensorTipo());
            sensor.setRegiao(sensorRequest.regiao());
            sensor.setDadosDescricao(sensorRequest.descricao());
            sensor.setProtocoloComunicacao(sensorRequest.protocoloComunicacao());
            return sensorRepository.save(sensor);
        });
    }

    @Override
    public void deleteSensor(UUID uuid) {
    try {
        var findSensorId=sensorRepository.findSensorByID(uuid).orElseThrow(()-> new ModelNotFoundException("Not found!"));
        sensorRepository.delete(findSensorId);
    }catch (RuntimeException e){
        log.error("Error: {}",e.getMessage());
    }
    }
}
