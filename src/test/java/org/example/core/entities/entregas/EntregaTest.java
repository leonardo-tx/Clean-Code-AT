package org.example.core.entities.entregas;

import org.example.core.entities.fretes.FreteTipo;
import org.example.core.utils.exceptions.ExampleOrgErro;
import org.example.core.utils.exceptions.ExampleOrgException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaTest {
    private final String enderecoValido = "Endereço, 123";
    private final double pesoValido = 5.0;
    private final FreteTipo freteValido = FreteTipo.PADRAO;
    private final String destinatarioValido = "Cliente Teste";

    @Test
    void criarEntregaValido() {
        assertDoesNotThrow(() -> new Entrega(
                enderecoValido,
                pesoValido,
                freteValido,
                destinatarioValido
        ));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void criarEntregaComEnderecoInvalido(String enderecoInvalido) {
        ExampleOrgException ex = assertThrows(
                ExampleOrgException.class,
                () -> new Entrega(
                        enderecoInvalido,
                        pesoValido,
                        freteValido,
                        destinatarioValido
                )
        );
        assertEquals(ExampleOrgErro.ENDERECO_NULO_OU_VAZIO, ex.getCodigoErro());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -2.5, -150.0})
    void criarEntregaComPesoInvalido(double pesoInvalido) {
        ExampleOrgException ex = assertThrows(
                ExampleOrgException.class,
                () -> new Entrega(
                        enderecoValido,
                        pesoInvalido,
                        freteValido,
                        destinatarioValido
                )
        );
        assertEquals(ExampleOrgErro.PESO_INVALIDO, ex.getCodigoErro());
    }

    @Test
    void criarEntregaComFreteTipoNulo() {
        ExampleOrgException ex = assertThrows(
                ExampleOrgException.class,
                () -> new Entrega(
                        enderecoValido,
                        pesoValido,
                        null,
                        destinatarioValido
                )
        );
        assertEquals(ExampleOrgErro.FRETE_TIPO_NULO, ex.getCodigoErro());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void criarEntregaComDestinatarioInvalido(String destinatarioInvalido) {
        ExampleOrgException ex = assertThrows(
                ExampleOrgException.class,
                () -> new Entrega(
                        enderecoValido,
                        pesoValido,
                        freteValido,
                        destinatarioInvalido
                )
        );
        assertEquals(ExampleOrgErro.DESTINATARIO_NULO_OU_VAZIO, ex.getCodigoErro());
    }
}
