package org.example.core.entities.promocoes;

import org.example.core.entities.entregas.Entrega;

public interface PromocaoFrete {
    double aplicarDesconto(Entrega entrega, double preco);
    boolean isAplicavel(Entrega entrega);
}
