package smarthouse.Sensores.api.services.sensorService;

import smarthouse.Sensores.api.dtos.SensorRequest;
import smarthouse.Sensores.api.dtos.SensorResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SensorService {
    List<SensorResponse>findSensorList();
    Optional<SensorResponse>findSensorId(UUID uuid);
    void createSensor(SensorRequest sensorRequest);
    void updateSensor(UUID uuid,SensorRequest sensorRequest);
    void deleteSensor(UUID uuid);
}
