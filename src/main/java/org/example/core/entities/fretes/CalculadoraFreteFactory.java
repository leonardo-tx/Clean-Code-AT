package org.example.core.entities.fretes;

public final class CalculadoraFreteFactory {
    public static CalculadoraFrete criar(FreteTipo freteTipo) {
        return switch (freteTipo) {
            case EXPRESSO -> new FreteExpresso();
            case PADRAO -> new FretePadrao();
            case ECONOMICO -> new FreteEconomico();
        };
    }
}
