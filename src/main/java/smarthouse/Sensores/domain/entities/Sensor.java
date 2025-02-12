package smarthouse.Sensores.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import smarthouse.Sensores.domain.entities.enums.SensorTipo;
import smarthouse.Sensores.domain.entities.enums.UnidadeMemoria;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sensor")
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Sensor extends Entidade{
    @Column(nullable = false,name = "nome",length = 15)
    private String name;
    @Column(name = "localizacao_sensor")
    private Localizacao localizacao;
    @Column(name = "tipo_sensor")
    private SensorTipo sensorTipo;
    @Column(name = "status")
    private Boolean ativadoDesativado;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateTimeSerializerBase.class)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime horarioAcionamento;
    @Column(name = "memoria_usada", precision = 15, scale = 2)
    private Long memoriaUsada;
    @Column(name = "memoria_disponivel", precision = 15, scale = 2)
    private Long memoriaDisponivel;
    @Column(name = "valor_dados_transferencia", precision = 15, scale = 2)
    private Long valorDadosTransferencia;
    @Column(name = "decricao_dados")
    private String dadosDescricao;
    @Enumerated(EnumType.STRING)
    private UnidadeMemoria unidadeMemoria;

}
