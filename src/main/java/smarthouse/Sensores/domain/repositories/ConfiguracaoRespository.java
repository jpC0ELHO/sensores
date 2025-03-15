package smarthouse.Sensores.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import smarthouse.Sensores.domain.entities.Configuracao;
import smarthouse.Sensores.domain.entities.Sensor;

import java.util.Optional;
import java.util.UUID;

public interface ConfiguracaoRespository extends JpaRepository<Configuracao, UUID> {
    Optional<Configuracao>findById(UUID uuid);
    Optional<Configuracao>findBySensor(Sensor sensor);

}
