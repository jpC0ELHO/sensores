package smarthouse.Sensores.api.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import smarthouse.Sensores.domain.entities.Evento;
import smarthouse.Sensores.domain.entities.Localizacao;
import smarthouse.Sensores.domain.entities.Sensor;
import smarthouse.Sensores.domain.entities.enums.EventoTipo;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({"uuid","tipoEvento","local","descricao","horarioEvento","eventoTipo","Sensor","createdBy",
        "lastModifiedBy","createdAt","updateAt"})
public record EventoResponse(
        UUID uuid,
        String tipoEvento,
        Localizacao local,
        String descricao,
        LocalDateTime horarioEvento,
        EventoTipo eventoTipo,
        Sensor sensor,
        String createdBy,
        String lastModifiedBy,
        LocalDateTime createdAt,
        LocalDateTime updateAt

) {
    public static EventoResponse toResponse(Evento evento){
        if (evento==null){
            return null;
        }
        return new EventoResponse(
                evento.getUuid(),
                evento.getTipoEvento(),
                evento.getLocal(),
                evento.getTipoEvento(),
                evento.getHorarioEvento(),
                evento.getEventoTipo(),
                evento.getSensor(),
                evento.getCreatedBy(),
                evento.getLastModifiedBy(),
                evento.getCreatedAt(),
                evento.getUpdateAt()
        );
    }
}
