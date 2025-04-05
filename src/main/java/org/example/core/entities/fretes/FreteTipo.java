package org.example.core.entities.fretes;

public enum FreteTipo {
    EXPRESSO("EXP"),
    PADRAO("PAD"),
    ECONOMICO("ECO");

    private final String sigla;

    FreteTipo(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }
}
