package smarthouse.Sensores.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import smarthouse.Sensores.domain.entities.Localizacao;
import smarthouse.Sensores.domain.entities.Sensor;
import smarthouse.Sensores.domain.entities.enums.Regiao;

import java.util.Optional;
import java.util.UUID;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, UUID> {
    Optional<Localizacao>findById(UUID uuid);
    Optional<Localizacao>findByLatitude(Double latitude);
    Optional<Localizacao>findByLongitude(Double longitude);
}
