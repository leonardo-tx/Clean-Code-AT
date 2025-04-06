package org.example.core.services;

import org.example.core.entities.entregas.Entrega;
import org.example.core.entities.fretes.CalculadoraFrete;
import org.example.core.entities.fretes.FreteTipo;
import org.example.core.utils.exceptions.ExampleOrgErro;
import org.example.core.utils.exceptions.ExampleOrgException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EtiquetaServiceTest {
    @Mock
    private CalculadoraFrete calculadoraFrete;

    @InjectMocks
    private EtiquetaServiceImpl etiquetaService;

    private final Entrega entregaValida = new Entrega(
            "Endereço ABC",
            5.0,
            FreteTipo.PADRAO,
            "Destinatário"
    );

    public EtiquetaServiceTest() throws ExampleOrgException {
    }

    @Test
    void gerarEtiqueta() throws ExampleOrgException {
        when(calculadoraFrete.calcular(entregaValida)).thenReturn(12.5);

        String etiqueta = assertDoesNotThrow(() -> etiquetaService.gerarEtiqueta(entregaValida));
        assertTrue(etiqueta.contains("Destinatário: Destinatário\n"));
        assertTrue(etiqueta.contains("Endereço: Endereço ABC\n"));
        assertTrue(etiqueta.contains("Valor do frete: R$12.5"));
        assertEquals(3, etiqueta.lines().count());
    }

    @Test
    void deveGerarResumoPedidoCorretamente() throws ExampleOrgException {
        when(calculadoraFrete.calcular(entregaValida)).thenReturn(12.5);

        String resumo = assertDoesNotThrow(() -> etiquetaService.gerarResumoEntrega(entregaValida));
        assertTrue(resumo.contains("Pedido para: Destinatário"));
        assertTrue(resumo.contains("com frete tipo: PAD"));
        assertTrue(resumo.contains("no valor de R$12.5"));
    }

    @Test
    void deveValidarEntregaNulaAoGerarEtiqueta() {
        ExampleOrgException ex = assertThrows(
                ExampleOrgException.class,
                () -> etiquetaService.gerarEtiqueta(null)
        );
        assertEquals(ExampleOrgErro.ENTREGA_NULA, ex.getCodigoErro());
    }

    @Test
    void deveValidarEntregaNulaAoGerarResumo() {
        ExampleOrgException ex = assertThrows(
                ExampleOrgException.class,
                () -> etiquetaService.gerarResumoEntrega(null)
        );
        assertEquals(ExampleOrgErro.ENTREGA_NULA, ex.getCodigoErro());
    }
}
