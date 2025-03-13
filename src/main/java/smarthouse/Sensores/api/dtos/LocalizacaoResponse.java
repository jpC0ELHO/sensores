package smarthouse.Sensores.api.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import smarthouse.Sensores.domain.entities.Localizacao;
import smarthouse.Sensores.domain.entities.Sensor;
import smarthouse.Sensores.domain.entities.enums.ProtocoloComunicacao;
import smarthouse.Sensores.domain.entities.enums.Regiao;
import smarthouse.Sensores.domain.exceptions.ModelNotFoundException;

import java.time.LocalDateTime;

@JsonPropertyOrder({"sensor","latitude","longitude","regiao","protocoloComunicacao","dataInstalacao",
"createdBy","lastModifiedBy","createdAt","updateAt"})
public record LocalizacaoResponse(
    Sensor sensor,
    Double latitude,
    Double longitude,
    Regiao regiao,
    ProtocoloComunicacao protocoloComunicacao,
    LocalDateTime dataInstalacao,
    String createdBy,
    String lastModifiedBy,
    LocalDateTime createdAt,
    LocalDateTime updateAt
) {
    public static LocalizacaoResponse toResponse(Localizacao localizacao){
        if (localizacao==null){
            throw new ModelNotFoundException("Not found!");
        }
        return new LocalizacaoResponse(
                localizacao.getSensor(),
                localizacao.getLatitude(),
                localizacao.getLongitude(),
                localizacao.getRegiao(),
                localizacao.getProtocoloComunicacao(),
                localizacao.getDataInstalacao(),
                localizacao.getCreatedBy(),
                localizacao.getLastModifiedBy(),
                localizacao.getCreatedAt(),
                localizacao.getUpdateAt()
        );
    }
}
