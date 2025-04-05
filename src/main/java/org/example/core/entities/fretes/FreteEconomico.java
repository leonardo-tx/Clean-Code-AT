package org.example.core.entities.fretes;

import org.example.core.entities.entregas.Entrega;
import org.example.core.utils.fretes.PromocaoDeFrete;

public final class FreteEconomico implements CalculadoraFrete {
    private static final double LIMIAR_DE_PESO_PARA_FRETE_GRATIS = 2.0;
    private static final double TAXA_MULTIPLICATIVA = 1.1;
    private static final double DESCONTO_ADICIONAL = 5;

    @Override
    public double calcular(Entrega entrega) {
        double pesoEmQuilogramas = PromocaoDeFrete.descontarPesoSeAplicavel(entrega);
        if (pesoEmQuilogramas < LIMIAR_DE_PESO_PARA_FRETE_GRATIS) {
            return 0.00;
        }
        return pesoEmQuilogramas * TAXA_MULTIPLICATIVA - DESCONTO_ADICIONAL;
    }

    @Override
    public FreteTipo getTipo() {
        return FreteTipo.ECONOMICO;
    }
}
