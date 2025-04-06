package org.example.core.services;

import org.example.core.entities.entregas.Entrega;
import org.example.core.entities.fretes.CalculadoraFrete;
import org.example.core.utils.exceptions.ExampleOrgErro;
import org.example.core.utils.exceptions.ExampleOrgException;

public class EtiquetaServiceImpl implements EtiquetaService {
    private final CalculadoraFrete calculadoraFrete;

    public EtiquetaServiceImpl(CalculadoraFrete calculadoraFrete) {
        this.calculadoraFrete = calculadoraFrete;
    }

    public String gerarEtiqueta(Entrega entrega) throws ExampleOrgException {
        if (entrega == null) {
            throw new ExampleOrgException(ExampleOrgErro.ENTREGA_NULA, "A entrega não pode ser nula.");
        }

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

    public String gerarResumoEntrega(Entrega entrega) throws ExampleOrgException {
        if (entrega == null) {
            throw new ExampleOrgException(ExampleOrgErro.ENTREGA_NULA, "A entrega não pode ser nula.");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pedido para: ")
                .append(entrega.getDestinatario())
                .append(' ');
        stringBuilder.append("com frete tipo: ")
                .append(entrega.getFreteTipo().getSigla())
                .append(' ');
        stringBuilder.append("no valor de R$")
                .append(calculadoraFrete.calcular(entrega));

        return stringBuilder.toString();
    }
}
