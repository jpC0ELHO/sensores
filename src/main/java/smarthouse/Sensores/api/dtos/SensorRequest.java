package smarthouse.Sensores.api.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import smarthouse.Sensores.domain.entities.Localizacao;
import smarthouse.Sensores.domain.entities.Sensor;
import smarthouse.Sensores.domain.entities.enums.ProtocoloComunicacao;
import smarthouse.Sensores.domain.entities.enums.SensorTipo;
import smarthouse.Sensores.domain.entities.enums.UnidadeMemoria;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SensorRequest(
        @NotNull
        @NotBlank
        String name,
        @NotNull
        @NotBlank
        Localizacao localizacao,
        @NotNull
        @NotBlank
        SensorTipo sensorTipo,
        @NotNull
        @NotBlank
        boolean ativadoDesativado,
        @NotNull
        @NotBlank
        LocalDateTime horarioAcionamento,
        @NotNull
        BigDecimal memoriaUsada,
        @NotNull
        BigDecimal memoriaDisponivel,
        @NotNull
        @NotBlank
        BigDecimal valorDadosTransferencia,
        @NotBlank
        String descricao,
        @NotNull
        @NotBlank
        UnidadeMemoria unidadeMemoria,
        @NotNull
        @NotBlank
        ProtocoloComunicacao protocoloComunicacao
) {
    public static Sensor toEntidade(SensorRequest sensorRequest){
        if (sensorRequest==null){
            throw new NullPointerException("Null");
        }
        return new Sensor(
                sensorRequest.name,
                sensorRequest.localizacao,
                sensorRequest.sensorTipo,
                sensorRequest.ativadoDesativado,
                sensorRequest.horarioAcionamento,
                sensorRequest.memoriaUsada,
                sensorRequest.memoriaDisponivel,
                sensorRequest.valorDadosTransferencia,
                sensorRequest.descricao,
                sensorRequest.unidadeMemoria,
                sensorRequest.protocoloComunicacao
        );
    }
}
