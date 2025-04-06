package org.example.core.entities.fretes;

import org.example.core.entities.entregas.Entrega;
import org.example.core.entities.promocoes.PromocaoFrete;

import java.util.List;

public abstract class FreteStrategy implements CalculadoraFrete {
    private final List<PromocaoFrete> promocoes;

    public FreteStrategy(List<PromocaoFrete> promocoes) {
        this.promocoes = promocoes;
    }

    protected double aplicarDescontoDisponivel(Entrega entrega, double preco) {
        double melhorDesconto = preco;
        for (PromocaoFrete promocaoFrete : promocoes) {
            if (!promocaoFrete.isAplicavel(entrega)) continue;

            double descontoAtual = promocaoFrete.aplicarDesconto(entrega, preco);
            if (descontoAtual < melhorDesconto) {
                melhorDesconto = descontoAtual;
            }
        }
        return melhorDesconto;
    }

    protected void validarFreteTipoDaEntrega(Entrega entrega) {
        if (entrega.getFreteTipo() != getTipo()) {
            throw new IllegalArgumentException("O tipo de frete da entrega e da estratégia são diferentes.");
        }
    }
}
