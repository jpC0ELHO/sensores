package smarthouse.Sensores.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import smarthouse.Sensores.domain.entities.Sensor;
import smarthouse.Sensores.domain.entities.enums.Regiao;
import smarthouse.Sensores.domain.entities.enums.SensorTipo;

import java.util.Optional;
import java.util.UUID;

public interface SensorRepository extends JpaRepository<Sensor, UUID> {
    Optional<Sensor>findSensorByID(UUID uuid);
    Optional<Sensor>findByRegiao(Regiao regiao);
    Optional<Sensor>findBySensorTipo(SensorTipo sensorTipo);
}
