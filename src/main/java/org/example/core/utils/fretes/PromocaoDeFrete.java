package org.example.core.utils.fretes;

import org.example.core.entities.entregas.Entrega;

public final class PromocaoDeFrete {
    public static double descontarPesoSeAplicavel(Entrega entrega) {
        if (entrega.getPesoEmQuilogramas() > 10) {
            return entrega.getPesoEmQuilogramas() - 1;
        }
        return entrega.getPesoEmQuilogramas();
    }
}
