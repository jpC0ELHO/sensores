package smarthouse.Sensores.api.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import smarthouse.Sensores.domain.entities.Evento;
import smarthouse.Sensores.domain.entities.Localizacao;
import smarthouse.Sensores.domain.entities.Sensor;
import smarthouse.Sensores.domain.entities.enums.EventoTipo;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record EventoRequest(
        String tipoEvento,
        Localizacao local,
        String descricao,
        LocalDateTime horarioEvento,
        EventoTipo eventoTipo,
        Sensor sensor
) {
    public static Evento toEntidade(EventoRequest eventoRequest){
        if (eventoRequest==null){
            return null;
        }
        return new Evento(
                eventoRequest.tipoEvento(),
                eventoRequest.local(),
                eventoRequest.descricao(),
                eventoRequest.horarioEvento(),
                eventoRequest.eventoTipo(),
                eventoRequest.sensor()
        );
    }
}
