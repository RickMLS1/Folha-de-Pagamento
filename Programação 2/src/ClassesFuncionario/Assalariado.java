package ClassesFuncionario;

import java.util.ArrayList;
import FolhaDePagamentoClasses.Excecoes;

public class Assalariado extends Funcionario
{
    public Assalariado(int funcionarioId, String nome, String endereco, int tipo, int isSindicato, int metodoPag, String tipoCronograma, int freqDiaria)
    {
        super(funcionarioId, nome, endereco, tipo, isSindicato, metodoPag, tipoCronograma, freqDiaria);
    }

    private double salarioAssalariadoFix;
    private double salarioAssalariadoLiq;

    @Override
    public void salario()
    {
        System.out.println("Digite o salário fixo mensal:\nEmxemplo: 1700 - 3043,23\nR$: ");
        double salarioTemp = Excecoes.readDouble();

        this.salarioAssalariadoFix = salarioTemp;
    }

    @Override
    public void pagFuncionario(ArrayList<Funcionario> funcionario, int index)
    {
        this.salarioAssalariadoLiq = salarioAssalariadoFix - getSindicato().getSindicatoTax() - getSindicato().getValorTaxaServico();
        System.out.println(funcionario.get(index).toString() + "\n");

        this.salarioAssalariadoLiq = 0;
    }

    public double getSalarioAssalariadoFix()
    {
        return salarioAssalariadoFix;
    }

    public double getSalarioAssalariadoLiq()
    {
        return salarioAssalariadoLiq;
    }

    @Override
    public String toString()
    {
        String string;

        string = super.toString();

        string += "Tipo: Assalariado		Salário Bruto: R$ " + this.salarioAssalariadoFix;
        string += "\n--------------------------------------------------------------------------------------------------------\n";
        string += "Agenda de Pagamento: " + this.getTipoCronograma() + "	Dia: " + this.getFreqDiaria();
        string += "\n________________________________________________________________________________________________________\n\n";

        return string;
    }
}
