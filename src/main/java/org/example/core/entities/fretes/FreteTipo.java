package org.example.core.entities.fretes;

public enum FreteTipo {
    EXPRESSO("EXP"),
    PADRAO("PAD"),
    ECONOMICO("ECO");

    public final String sigla;

    FreteTipo(String sigla) {
        this.sigla = sigla;
    }
}
