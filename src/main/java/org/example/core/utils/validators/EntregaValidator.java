package org.example.core.utils.validators;

import org.example.core.entities.fretes.FreteTipo;
import org.example.core.utils.exceptions.ExampleOrgErro;
import org.example.core.utils.exceptions.ExampleOrgException;

public final class EntregaValidator {
    public static void validarEndereco(String endereco) throws ExampleOrgException {
        if (endereco == null || endereco.isBlank()) {
            throw new ExampleOrgException(
                    ExampleOrgErro.ENDERECO_NULO_OU_VAZIO,
                    "O endereço não pode ser nulo ou vazio."
            );
        }
    }

    public static void validarPesoEmQuilogramas(double pesoEmQuilogramas) throws ExampleOrgException {
        if (pesoEmQuilogramas <= 0) {
            throw new ExampleOrgException(
                    ExampleOrgErro.PESO_INVALIDO,
                    "O peso deve ser maior que 0."
            );
        }
    }

    public static void validarFreteTipo(FreteTipo freteTipo) throws ExampleOrgException {
        if (freteTipo == null) {
            throw new ExampleOrgException(
                    ExampleOrgErro.FRETE_TIPO_NULO,
                    "O tipo de frete não pode ser nulo"
            );
        }
    }

    public static void validarDestinatario(String destinatario) throws ExampleOrgException {
        if (destinatario == null || destinatario.isBlank()) {
            throw new ExampleOrgException(
                    ExampleOrgErro.DESTINATARIO_NULO_OU_VAZIO,
                    "O destinatário não pode ser nulo ou vazio."
            );
        }
    }
}
