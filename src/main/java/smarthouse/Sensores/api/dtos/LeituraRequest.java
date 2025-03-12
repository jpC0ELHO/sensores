package smarthouse.Sensores.api.dtos;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import smarthouse.Sensores.domain.entities.Leitura;
import smarthouse.Sensores.domain.entities.Localizacao;
import smarthouse.Sensores.domain.entities.Sensor;
import smarthouse.Sensores.domain.entities.enums.DeteccaoTipo;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record LeituraRequest(
        boolean deteccao_sim_nao,
        DeteccaoTipo deteccaoTipo,
        LocalDateTime horarioDetec,
        Localizacao localizacao,
        Sensor sensor
) {
    public static Leitura toEntidade(LeituraRequest leituraRequest){
        if (leituraRequest==null){
            throw new NullPointerException("Error!");
        }
        return new Leitura(
                leituraRequest.deteccao_sim_nao,
                leituraRequest.deteccaoTipo,
                leituraRequest.horarioDetec,
                leituraRequest.localizacao,
                leituraRequest.sensor
        );
    }
}
