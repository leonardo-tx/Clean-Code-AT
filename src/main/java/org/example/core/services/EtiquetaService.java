package org.example.core.services;

import org.example.core.entities.entregas.Entrega;
import org.example.core.utils.exceptions.ExampleOrgException;

public interface EtiquetaService {
    String gerarEtiqueta(Entrega entrega) throws ExampleOrgException;
    String gerarResumoEntrega(Entrega entrega) throws ExampleOrgException;
}
