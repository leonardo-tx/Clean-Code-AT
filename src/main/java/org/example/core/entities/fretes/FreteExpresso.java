package org.example.core.entities.fretes;

import org.example.core.entities.entregas.Entrega;
import org.example.core.entities.promocoes.PromocaoFrete;

import java.util.List;

public final class FreteExpresso extends FreteStrategy {
    private static final double TAXA_MULTIPLICATIVA = 1.5;
    private static final double TAXA_ADICIONAL = 10;

    public FreteExpresso(List<PromocaoFrete> promocoes) {
        super(promocoes);
    }

    @Override
    public double calcular(Entrega entrega) {
        validarFreteTipoDaEntrega(entrega);

        double preco = entrega.getPesoEmQuilogramas() * TAXA_MULTIPLICATIVA + TAXA_ADICIONAL;
        double precoDescontado = aplicarDescontoDisponivel(entrega, preco);

        return Math.max(precoDescontado, 0.0);
    }

    @Override
    public FreteTipo getTipo() {
        return FreteTipo.EXPRESSO;
    }
}
