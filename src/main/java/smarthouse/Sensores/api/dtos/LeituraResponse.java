package smarthouse.Sensores.api.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import smarthouse.Sensores.domain.entities.Leitura;
import smarthouse.Sensores.domain.entities.Localizacao;
import smarthouse.Sensores.domain.entities.Sensor;
import smarthouse.Sensores.domain.entities.enums.DeteccaoTipo;

import java.time.LocalDateTime;

@JsonPropertyOrder({"deteccao_sim_nao","deteccaoTipo","horarioDetec","localizacao","sensor"
        ,"createdBy","lastModifiedBy"
        ,"createdAt","updateAt"})
public record LeituraResponse(
        boolean deteccao_sim_nao,
        DeteccaoTipo deteccaoTipo,
        LocalDateTime horarioDetec,
        Localizacao localizacao,
        Sensor sensor,
        String createdBy,
        String lastModifiedBy,
        LocalDateTime createdAt,
        LocalDateTime updateAt
) {
    public static LeituraResponse toResponse(Leitura leitura){
        if (leitura==null){
            throw new RuntimeException("Error");
        }
        return new LeituraResponse(
                leitura.getDeteccao_sim_nao(),
                leitura.getDeteccaoTipo(),
                leitura.getHorarioDetec(),
                leitura.getLocalizacao(),
                leitura.getSensor(),
                leitura.getCreatedBy(),
                leitura.getLastModifiedBy(),
                leitura.getCreatedAt(),
                leitura.getUpdateAt()
        );
    }
}
