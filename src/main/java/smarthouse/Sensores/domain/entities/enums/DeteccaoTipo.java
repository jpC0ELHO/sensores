package smarthouse.Sensores.domain.entities.enums;

import lombok.Getter;

@Getter
public enum DeteccaoTipo {
    OBJETO("Objeto"),
    OBJETO_MOVIMENTO("Objeto em Movimento"),
    ANIMAL("Animal"),
    ANIMAL_MOVIMENTO("Animal em Movimento"),
    CALOR_ALTO("Calor Alto"),
    HIPERCALOR("Hipercalor");

    private final String descricao;

    DeteccaoTipo(String descricao){
        this.descricao=descricao;
    }
    public String getDescricao() {
        return descricao;
    }

    public static DeteccaoTipo fromDescricao(String descricao) {
        for (DeteccaoTipo tipo : DeteccaoTipo.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
            }
        throw new IllegalArgumentException("Tipo de deteccão inválido: " + descricao);
    }
}

