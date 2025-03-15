package smarthouse.Sensores.api.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import smarthouse.Sensores.domain.entities.Configuracao;
import smarthouse.Sensores.domain.entities.Sensor;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ConfiguracaoRequest(
        @NotNull
        Double limiteMax,
        @NotNull
        Double limiteMin,
        @NotNull
        @NotBlank
        Sensor sensor
) {
    public static Configuracao toEntidade(ConfiguracaoRequest configuracaoRequest){
        if (configuracaoRequest==null){
            throw new NullPointerException("Error");
        }
        return new Configuracao(
                configuracaoRequest.limiteMax,
                configuracaoRequest.limiteMin,
                configuracaoRequest.sensor
        );
    }
}
