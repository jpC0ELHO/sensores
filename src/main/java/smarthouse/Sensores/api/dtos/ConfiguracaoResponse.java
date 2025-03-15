package smarthouse.Sensores.api.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import smarthouse.Sensores.domain.entities.Configuracao;
import smarthouse.Sensores.domain.entities.Sensor;

import java.time.LocalDateTime;

@JsonPropertyOrder({"limiteMax","limiteMin","sensor","createdBy","lastModifiedBy","createdAt","updateAt"})
public record ConfiguracaoResponse(
        Double limiteMax,
        Double limiteMin,
        Sensor sensor,
        String createdBy,
        String lastModifiedBy,
        LocalDateTime createdAt,
        LocalDateTime updateAt
) {
    public static ConfiguracaoResponse toResponse(Configuracao configuracao){
        if (configuracao==null){
            throw new NullPointerException("Error!");
        }
        return new ConfiguracaoResponse(
                configuracao.getLimiteMax(),
                configuracao.getLimiteMin(),
                configuracao.getSensor(),
                configuracao.getCreatedBy(),
                configuracao.getLastModifiedBy(),
                configuracao.getCreatedAt(),
                configuracao.getUpdateAt()
        );
    }
}
