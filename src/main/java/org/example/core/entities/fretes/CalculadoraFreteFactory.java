package org.example.core.entities.fretes;

import org.example.core.entities.promocoes.PromocaoFrete;

import java.util.List;

public class CalculadoraFreteFactory {
    private final List<PromocaoFrete> promocoes;

    public CalculadoraFreteFactory(List<PromocaoFrete> promocoes) {
        this.promocoes = promocoes;
    }

    public CalculadoraFrete criar(FreteTipo freteTipo) {
        return switch (freteTipo) {
            case EXPRESSO -> new FreteExpresso(promocoes);
            case PADRAO -> new FretePadrao(promocoes);
            case ECONOMICO -> new FreteEconomico(promocoes);
        };
    }
}
