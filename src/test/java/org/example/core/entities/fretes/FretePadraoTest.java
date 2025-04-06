package org.example.core.entities.fretes;

import org.example.core.entities.entregas.Entrega;
import org.example.core.entities.promocoes.DescontoAcimaDezQuilos;
import org.example.core.entities.promocoes.PromocaoFrete;
import org.example.core.utils.exceptions.ExampleOrgException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FretePadraoTest {
    private final List<PromocaoFrete> promocoesVazias = List.of();
    private final List<PromocaoFrete> promocoesAtivas = List.of(new DescontoAcimaDezQuilos());

    @Test
    void validarTipo() {
        CalculadoraFrete calculadora = new FretePadrao(promocoesVazias);
        assertEquals(FreteTipo.PADRAO, calculadora.getTipo());
    }

    @Test
    void validarExcecaoComEntregaComFreteTipoErrado1() throws ExampleOrgException {
        CalculadoraFrete calculadora = new FretePadrao(promocoesVazias);
        Entrega entrega = new Entrega(
                "Endereço X",
                5.0,
                FreteTipo.ECONOMICO,
                "Cliente"
        );
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcular(entrega));
    }

    @Test
    void validarExcecaoComEntregaComFreteTipoErrado2() throws ExampleOrgException {
        CalculadoraFrete calculadora = new FretePadrao(promocoesVazias);
        Entrega entrega = new Entrega(
                "Endereço X",
                5.0,
                FreteTipo.EXPRESSO,
                "Cliente"
        );
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcular(entrega));
    }

    @Test
    void calcularFreteSemPromocaoAbaixoDe10kg() throws ExampleOrgException {
        CalculadoraFrete calculadora = new FretePadrao(promocoesVazias);
        Entrega entrega = new Entrega(
                "Endereço X",
                5.0,
                FreteTipo.PADRAO,
                "Cliente"
        );
        assertEquals(6.0, calculadora.calcular(entrega));
    }

    @Test
    void calcularFreteSemPromocaoAcimaDe10kg() throws ExampleOrgException {
        CalculadoraFrete calculadora = new FretePadrao(promocoesVazias);
        Entrega entrega = new Entrega(
                "Endereço Y",
                15.0,
                FreteTipo.PADRAO,
                "Cliente"
        );
        assertEquals(18.0, calculadora.calcular(entrega));
    }

    @Test
    void calcularFreteComDescontoParaPesoAcimaDe10kg() throws ExampleOrgException {
        CalculadoraFrete calculadora = new FretePadrao(promocoesAtivas);
        Entrega entrega = new Entrega(
                "Endereço Y",
                15.0,
                FreteTipo.PADRAO,
                "Cliente"
        );
        assertEquals(16.5, calculadora.calcular(entrega));
    }

    @Test
    void calcularFreteComDescontoNaoAplicadoParaPesoAcimaDe10kg() throws ExampleOrgException {
        CalculadoraFrete calculadora = new FretePadrao(promocoesAtivas);
        Entrega entrega = new Entrega(
                "Endereço Z",
                1.0,
                FreteTipo.PADRAO,
                "Cliente"
        );
        assertEquals(1.2, calculadora.calcular(entrega));
    }

    @Test
    void calcularFreteComDescontoNaoAplicadoParaPesoAcimaDe10kgEmLimiar() throws ExampleOrgException {
        CalculadoraFrete calculadora = new FretePadrao(promocoesAtivas);
        Entrega entrega = new Entrega(
                "Endereço Z",
                10.0,
                FreteTipo.PADRAO,
                "Cliente"
        );
        assertEquals(12.0, calculadora.calcular(entrega));
    }
}
