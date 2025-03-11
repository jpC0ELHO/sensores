package smarthouse.Sensores.api.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import smarthouse.Sensores.domain.entities.Localizacao;
import smarthouse.Sensores.domain.entities.Sensor;
import smarthouse.Sensores.domain.entities.enums.ProtocoloComunicacao;
import smarthouse.Sensores.domain.entities.enums.Regiao;
import smarthouse.Sensores.domain.entities.enums.SensorTipo;
import smarthouse.Sensores.domain.entities.enums.UnidadeMemoria;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonPropertyOrder({"name","localizacao","sensorTipo","regiao","ativadoDesativado",
        "horarioAcionamento","memoriaUsada","memoriaDisponivel"
        ,"valorDadosTransferencia","descricao","unidadeMemoria",
        "protocoloComunicacao","createdBy","lastModifiedBy"
,"createdAt","updateAt"})
public record SensorResponse (
        String name,
        Localizacao localizacao,
        SensorTipo sensorTipo,
        Regiao regiao,
        boolean ativadoDesativado,
        LocalDateTime horarioAcionamento,
        BigDecimal memoriaUsada,
        BigDecimal memoriaDisponivel,
        BigDecimal valorDadosTransferencia,
        String descricao,
        UnidadeMemoria unidadeMemoria,
        ProtocoloComunicacao protocoloComunicacao,
        String createdBy,
        String lastModifiedBy,
        LocalDateTime createdAt,
        LocalDateTime updateAt
){
    public static SensorResponse toResponse(Sensor sensor){
        if (sensor==null){
            throw new NullPointerException("Null");
        }
        return new SensorResponse(
                sensor.getName(),
                sensor.getLocalizacao(),
                sensor.getSensorTipo(),
                sensor.getRegiao(),
                sensor.isAtivadoDesativado(),
                sensor.getHorarioAcionamento(),
                sensor.getMemoriaUsada(),
                sensor.getMemoriaDisponivel(),
                sensor.getValorDadosTransferencia(),
                sensor.getDadosDescricao(),
                sensor.getUnidadeMemoria(),
                sensor.getProtocoloComunicacao(),
                sensor.getCreatedBy(),
                sensor.getLastModifiedBy(),
                sensor.getCreatedAt(),
                sensor.getUpdateAt()
        );
    }
}
