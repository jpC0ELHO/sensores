package smarthouse.Sensores.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import smarthouse.Sensores.domain.entities.Leitura;

import java.util.Optional;
import java.util.UUID;

public interface LeituraRespository extends JpaRepository<Leitura, UUID> {
    Optional<Leitura>findById(UUID uuid);
}
