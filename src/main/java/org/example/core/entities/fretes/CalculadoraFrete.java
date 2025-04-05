package org.example.core.entities.fretes;

import org.example.core.entities.entregas.Entrega;

public interface CalculadoraFrete {
    double calcular(Entrega entrega);

    FreteTipo getTipo();
}
