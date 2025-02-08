package smarthouse.Sensores.domain.entities.enums;

import lombok.Getter;

@Getter
public enum Eventos {
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

    Eventos(String descricao){
        this.descricao=descricao;
    }
}
