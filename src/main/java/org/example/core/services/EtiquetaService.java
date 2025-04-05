package org.example.core.services;

import org.example.core.entities.entregas.Entrega;
import org.example.core.entities.fretes.CalculadoraFrete;

public class EtiquetaService {
    private final CalculadoraFrete calculadoraFrete;

    public EtiquetaService(CalculadoraFrete calculadoraFrete) {
        this.calculadoraFrete = calculadoraFrete;
    }

    public String gerarEtiqueta(Entrega entrega) {
        validarSeEntregaCorrespondeACalculadora(entrega);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Destinatário: ")
                .append(entrega.getDestinatario())
                .append('\n');
        stringBuilder.append("Endereço: ")
                .append(entrega.getEndereco())
                .append('\n');
        stringBuilder.append("Valor do frete: R$")
                .append(calculadoraFrete.calcular(entrega));

        return stringBuilder.toString();
    }

    public String gerarResumoPedido(Entrega entrega) {
        validarSeEntregaCorrespondeACalculadora(entrega);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pedido para: ")
                .append(entrega.getDestinatario())
                .append(' ');
        stringBuilder.append("com frete tipo: ")
                .append(entrega.getFreteTipo().sigla)
                .append(' ');
        stringBuilder.append("no valor de R$")
                .append(calculadoraFrete.calcular(entrega));

        return stringBuilder.toString();
    }

    private void validarSeEntregaCorrespondeACalculadora(Entrega entrega) {
        if (entrega.getFreteTipo() != calculadoraFrete.getTipo()) {
            throw new IllegalArgumentException("O tipo de frete da Entrega e do serviço são diferentes.");
        }
    }
}
