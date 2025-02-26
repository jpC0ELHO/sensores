package smarthouse.Sensores.domain.entities.enums;

import lombok.Getter;

@Getter
public enum EventoTipo {
    //brevidades
    INCENDIO("INCENDIO"),
    COMBUSTAO("COMBUSTAO"),
    VAZAMENTO_GAS("VAZAMENTO GAS"),
    //Atipicos
    FALHA("FALHA"),
    LIQUIDO("LIQUIDO"),
    AMEACA("AMEACA"),
    //sensor de calor
    PRESENCA("PRESENCA"),
    //cameras de seguranca
    SUSPEITO("SUSPEITO"),
    CONHECIDO("CONEHCIDO");

    private final String descricao;

    EventoTipo(String descricao){
        this.descricao=descricao;
    }
}
