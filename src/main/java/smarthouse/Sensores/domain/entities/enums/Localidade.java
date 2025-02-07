package smarthouse.Sensores.domain.entities.enums;

import lombok.Getter;

@Getter
public enum Localidade {
    SALA("SALA"),
    QUARTO1("QUARTO1J"),
    QUARTO2("QUARTO2F"),
    ESCRITORIO("ESCRITORIO"),
    COZINHA("COZINHA"),
    BANHEIRO1("BANHEIRO1"),
    BANHEIRO2("BANHEIRO2F"),
    GARAGEM("GARAGEM"),
    CORREDOR_GARAGEM("CORREDOR GARAGEM");
    private final String descricao;

    Localidade(String descricao){
        this.descricao=descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public static Localidade fromLocalidade(String descricao){
        for (Localidade local:Localidade.values()){
            if (local.getDescricao().equalsIgnoreCase(descricao)){
                return local;
            }
        }
        throw new IllegalArgumentException("Localidade invalida: "+descricao);
    }
}
