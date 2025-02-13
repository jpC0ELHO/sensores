package smarthouse.Sensores.domain.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import smarthouse.Sensores.domain.entities.enums.Regiao;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "localizacao")
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Localizacao extends Entidade{
    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;
    @Column(precision = 5,scale = 2,name = "Longitude",nullable = false)
    private Double latitude;
    @Column(precision = 5,scale = 2,name = "Longitude",nullable = false)
    private Double longitude;
    @Enumerated(EnumType.STRING)
    private Regiao localidade;

}
