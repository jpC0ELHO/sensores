package smarthouse.Sensores.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import smarthouse.Sensores.domain.entities.enums.SensorTipo;
import smarthouse.Sensores.domain.entities.enums.UnidadeMemoria;

import java.math.BigDecimal;
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
    @Enumerated(EnumType.STRING)
    private SensorTipo sensorTipo;
    @Column(name = "status")
    private boolean ativadoDesativado;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime horarioAcionamento;
    @Column(name = "memoria_usada", precision = 15, scale = 2)
    private BigDecimal memoriaUsada;
    @Column(name = "memoria_disponivel", precision = 15, scale = 2)
    private BigDecimal memoriaDisponivel;
    @Column(name = "valor_dados_transferencia", precision = 15, scale = 2)
    private BigDecimal valorDadosTransferencia;
    @Column(name = "decricao_dados")
    private String dadosDescricao;
    @Enumerated(EnumType.STRING)
    private UnidadeMemoria unidadeMemoria;

}
