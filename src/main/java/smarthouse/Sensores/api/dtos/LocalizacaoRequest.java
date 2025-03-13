package smarthouse.Sensores.api.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import smarthouse.Sensores.domain.entities.Localizacao;
import smarthouse.Sensores.domain.entities.Sensor;
import smarthouse.Sensores.domain.entities.enums.ProtocoloComunicacao;
import smarthouse.Sensores.domain.entities.enums.Regiao;
import smarthouse.Sensores.domain.exceptions.ModelNotFoundException;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record LocalizacaoRequest (
        @NotBlank
        @NotNull
        Sensor sensor,
        @NotNull
        Double latitude,
        @NotNull
        Double longitude,
        @NotBlank
        @NotNull
        Regiao regiao,
        @NotBlank
        @NotNull
        ProtocoloComunicacao protocoloComunicacao,
        @NotBlank
        @NotNull
        LocalDateTime dataInstalacao
){
    public static Localizacao toEntidade(LocalizacaoRequest localizacaoRequest){
        if (localizacaoRequest==null){
            throw new ModelNotFoundException("Not found!");
        }
        return new Localizacao(
                localizacaoRequest.sensor,
                localizacaoRequest.latitude,
                localizacaoRequest.longitude,
                localizacaoRequest.regiao,
                localizacaoRequest.protocoloComunicacao,
                localizacaoRequest.dataInstalacao
        );
    }
}
