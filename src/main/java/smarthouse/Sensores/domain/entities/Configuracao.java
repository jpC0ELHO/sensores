package smarthouse.Sensores.domain.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@Getter
@Setter
@Table(name = "tb_configuracao")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Configuracao extends Entidade{
    @Column(nullable = false)
    private Double limiteMax;
    @Column(nullable = false)
    private Double limiteMin;
    @ManyToOne
    @JoinColumn
    @Column
    private Sensor sensor;
}
