package org.example.core.entities.entregas;

import org.example.core.entities.fretes.FreteTipo;
import org.example.core.utils.validators.EntregaValidator;
import org.example.core.utils.exceptions.ExampleOrgException;

public final class Entrega {
    private final String endereco;
    private final double pesoEmQuilogramas;
    private final FreteTipo freteTipo;
    private final String destinatario;

    public Entrega(
            String endereco,
            double pesoEmQuilogramas,
            FreteTipo freteTipo,
            String destinatario
    ) throws ExampleOrgException {
        EntregaValidator.validarEndereco(endereco);
        EntregaValidator.validarPesoEmQuilogramas(pesoEmQuilogramas);
        EntregaValidator.validarFreteTipo(freteTipo);
        EntregaValidator.validarDestinatario(destinatario);

        this.endereco = endereco;
        this.pesoEmQuilogramas = pesoEmQuilogramas;
        this.freteTipo = freteTipo;
        this.destinatario = destinatario;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getPesoEmQuilogramas() {
        return pesoEmQuilogramas;
    }

    public FreteTipo getFreteTipo() {
        return freteTipo;
    }

    public String getDestinatario() {
        return destinatario;
    }
}
