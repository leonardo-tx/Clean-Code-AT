package org.example.core.entities.fretes;

import org.example.core.entities.entregas.Entrega;
import org.example.core.utils.fretes.PromocaoDeFrete;

public final class FretePadrao implements CalculadoraFrete {
    private static final double TAXA_MULTIPLICATIVA = 1.2;

    @Override
    public double calcular(Entrega entrega) {
        double pesoEmQuilogramas = PromocaoDeFrete.descontarPesoSeAplicavel(entrega);
        return pesoEmQuilogramas * TAXA_MULTIPLICATIVA;
    }

    @Override
    public FreteTipo getTipo() {
        return FreteTipo.PADRAO;
    }
}
