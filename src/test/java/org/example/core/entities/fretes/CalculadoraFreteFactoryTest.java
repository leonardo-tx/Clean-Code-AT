package org.example.core.entities.fretes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CalculadoraFreteFactoryTest {
    private static final CalculadoraFreteFactory calculadoraFreteFactory =
            new CalculadoraFreteFactory(List.of());

    @Test
    void validarCriarCalculadoraFreteExpresso() {
        CalculadoraFrete calculadoraFrete = calculadoraFreteFactory.criar(FreteTipo.EXPRESSO);
        assertInstanceOf(FreteExpresso.class, calculadoraFrete);
    }

    @Test
    void validarCriarCalculadoraFretePadrao() {
        CalculadoraFrete calculadoraFrete = calculadoraFreteFactory.criar(FreteTipo.PADRAO);
        assertInstanceOf(FretePadrao.class, calculadoraFrete);
    }

    @Test
    void validarCriarCalculadoraFreteEconomico() {
        CalculadoraFrete calculadoraFrete = calculadoraFreteFactory.criar(FreteTipo.ECONOMICO);
        assertInstanceOf(FreteEconomico.class, calculadoraFrete);
    }
}
