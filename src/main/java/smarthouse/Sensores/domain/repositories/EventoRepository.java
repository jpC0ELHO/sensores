package smarthouse.Sensores.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import smarthouse.Sensores.domain.entities.Evento;

import java.util.Optional;
import java.util.UUID;

public interface EventoRepository  extends JpaRepository<Evento, UUID> {
    Optional<Evento>findById(UUID uuid);
}
