package org.example.core.entities.fretes;

import org.example.core.entities.entregas.Entrega;
import org.example.core.entities.promocoes.PromocaoFrete;

import java.util.List;

public final class FreteEconomico extends FreteStrategy {
    private static final double TAXA_MULTIPLICATIVA = 1.1;
    private static final double DESCONTO_ADICIONAL = 5;

    public FreteEconomico(List<PromocaoFrete> promocoes) {
        super(promocoes);
    }

    @Override
    public double calcular(Entrega entrega) {
        validarFreteTipoDaEntrega(entrega);

        double preco = entrega.getPesoEmQuilogramas() * TAXA_MULTIPLICATIVA - DESCONTO_ADICIONAL;
        double precoDescontado = aplicarDescontoDisponivel(entrega, preco);

        return Math.max(precoDescontado, 0.0);
    }

    @Override
    public FreteTipo getTipo() {
        return FreteTipo.ECONOMICO;
    }
}
