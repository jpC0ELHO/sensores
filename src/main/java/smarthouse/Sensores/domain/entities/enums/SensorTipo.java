package smarthouse.Sensores.domain.entities.enums;

import lombok.Getter;


@Getter
public enum SensorTipo {

    CO2("CO2"),
    FUMACA("FUMACA"),
    CHAMAS("CHAMAS"),
    GAS("GAS"),
    LIQUIDO("LIQUIDO"),
    CALOR("CALOR"),
    MOVIMENTO("MOVIMENTO"),
    SEGURANCA("SEGURANCA");

    private final String descricao;

    SensorTipo(String descricao){
        this.descricao=descricao;
    }

}
