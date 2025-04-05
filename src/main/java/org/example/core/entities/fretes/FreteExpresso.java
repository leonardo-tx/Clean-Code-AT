package org.example.core.entities.fretes;

import org.example.core.entities.entregas.Entrega;
import org.example.core.utils.fretes.PromocaoDeFrete;

public final class FreteExpresso implements CalculadoraFrete {
    private static final double TAXA_MULTIPLICATIVA = 1.5;
    private static final double TAXA_ADICIONAL = 10;

    @Override
    public double calcular(Entrega entrega) {
        double pesoEmQuilogramas = PromocaoDeFrete.descontarPesoSeAplicavel(entrega);
        return pesoEmQuilogramas * TAXA_MULTIPLICATIVA + TAXA_ADICIONAL;
    }

    @Override
    public FreteTipo getTipo() {
        return FreteTipo.EXPRESSO;
    }
}
