package smarthouse.Sensores.domain.entities.enums;

import lombok.Getter;

@Getter
public enum UnidadeMemoria {

    BYTES("BYTES"),KB("KB"),MB("MB"),GB("GB"),TB("TB");

    private final String descricao;

    UnidadeMemoria(String descricao){
        this.descricao=descricao;
    }

}
