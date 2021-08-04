package ClassesFuncionario;

import java.util.Scanner;
import FolhaDePagamentoClasses.Excecoes;

public class Sindicato
{
    Scanner input = new Scanner(System.in);

    private int sindicatoId;
    private double sindicatoTax = 0;
    private double valorTaxaServico = 0;

    public int getSindicatoId()
    {
        return sindicatoId;
    }

    public void setSindicatoId(int sindicatoId)
    {
        this.sindicatoId = sindicatoId;
    }

    public double getSindicatoTax()
    {
        return sindicatoTax;
    }

    public void setSindicatoTax(double sindicatoTax)
    {
        this.sindicatoTax = sindicatoTax;
    }

    public double getValorTaxaServico()
    {
        return valorTaxaServico;
    }

    public void servicoTax()
    {
        System.out.println("\nDigite o serviço adicional pelo Sindicato:\nR$ ");
        String servico = input.nextLine();

        System.out.println("Digite o valor da Taxa de Serviço");
        double servicoValor = Excecoes.readDouble();

        this.valorTaxaServico = valorTaxaServico + servicoValor;

        System.out.println("Número de série do sindicato: " + sindicatoId);
        System.out.println("----------------------------");
        System.out.println("Serviço: " + servico + "   Valor do Serviço: R$ " + servicoValor);
        System.out.println("----------------------------");
        System.out.println("Taxa de serviço registrado com sucesso!");

    }
}
