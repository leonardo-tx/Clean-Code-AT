package org.example.core.entities.promocoes;

import org.example.core.entities.entregas.Entrega;

public class DescontoAcimaDezQuilos implements PromocaoFrete {
    private static final double LIMIAR_DE_PESO_PARA_DESCONTO = 10.0;
    private static final double TAXA_DESCONTO = 0.1;

    @Override
    public double aplicarDesconto(Entrega entrega, double preco) {
        return Math.max(preco - entrega.getPesoEmQuilogramas() * TAXA_DESCONTO, 0.0);
    }

    @Override
    public boolean isAplicavel(Entrega entrega) {
        return entrega.getPesoEmQuilogramas() > LIMIAR_DE_PESO_PARA_DESCONTO;
    }
}
