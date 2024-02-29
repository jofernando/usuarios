package br.edu.ufape.usuarios.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoCivil {
    SOLTEIRO("solteiro"),
    CASADO("casado"),
    DIVORCIADO("divorciado"),
    VIUVO("viuvo");

    private final String value;

    EstadoCivil(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static EstadoCivil fromValue(String value) {
        for (EstadoCivil estadoCivil : EstadoCivil.values()) {
            if (estadoCivil.getValue().equalsIgnoreCase(value)) {
                return estadoCivil;
            }
        }
        throw new IllegalArgumentException("Estado civil inválido: " + value);
    }
}
