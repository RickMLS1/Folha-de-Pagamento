package ClassesFuncionario;

import java.util.ArrayList;
import FolhaDePagamentoClasses.Excecoes;

public class Comissionados extends Funcionario
{
    public Comissionados(int funcionarioId, String nome, String endereco, int tipo, int isSindicato, int metodoPag, String tipoCronograma, int freqDiaria)
    {
        super(funcionarioId, nome, endereco, tipo, isSindicato, metodoPag, tipoCronograma, freqDiaria);
    }

    private double salarioComissionadoFix;
    private double SalarioComissionadoLiq;
    private double valorComissao;
    private double comissao;

    @Override
    public void salario()
    {
        System.out.println("Digite o salário:");
        System.out.println("Exemplo: xxxx,xx\nR$: ");

        double salarioTemp = Excecoes.readDouble();

        System.out.println("Digite aqui o percentual da comissão: ");
        System.out.println("Exemplo: 10 para 10% 1.0 para 1.0%");

        this.comissao = Excecoes.readDouble();
        this.salarioComissionadoFix = salarioTemp;
    }

    @Override
    public void pagFuncionario(ArrayList<Funcionario> funcionario, int index)
    {
        this.SalarioComissionadoLiq = salarioComissionadoFix + valorComissao - getSindicato().getSindicatoTax() - getSindicato().getValorTaxaServico();
        System.out.println(funcionario.get(index).toString() + "\n");

        this.SalarioComissionadoLiq = 0;
        this.valorComissao = 0;
    }

    public void vendasResult()
    {
        System.out.println("Dia da Venda:");
        int vendasDia = Excecoes.readInt();

        System.out.println("Mês da Venda");
        int vendasMes = Excecoes.readInt();

        System.out.println("Ano da Venda");
        int vendasAno = Excecoes.readInt();

        System.out.println("\nValor da Venda:\nPor exemplo: 1800 - 3033,56\nR$: ");
        double vendasValor = Excecoes.readDouble();

        this.valorComissao = (vendasValor * comissao) / 100;

        System.out.println("\n===============================Registro de Venda=================================");
        System.out.println("Nome: " + getNome() + "       Número do empregado: " + getFuncionarioId());
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Data da venda: " + vendasDia + "/ " + vendasMes + "/" + vendasAno + "     Valor da comissão: R$ " + ((vendasValor * comissao) / 100));

        System.out.println("==================================================================================");

        System.out.println("\nResultado da venda do empregado foi registrado com sucesso!");
    }

    public double getSalarioComissionadoFix()
    {
        return salarioComissionadoFix;
    }

    public double getSalarioComissionadoLiq()
    {
        return SalarioComissionadoLiq;
    }

    public double getComissao()
    {
        return comissao;
    }

    @Override
    public String toString()
    {
        String string, diaString = null;

        string = super.toString();

        string += "Tipo: Comissionado     Salário Bruto: R$ " + this.salarioComissionadoFix + "  Comissão: " + this.comissao + "%";
        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (getFreqDiaria() == 1) diaString = "Segunda";
        else if (getFreqDiaria() == 2) diaString = "Terça";
        else if (getFreqDiaria() == 3) diaString = "Quarta";
        else if (getFreqDiaria() == 4) diaString= "Quinta";
        else if (getFreqDiaria() == 5) diaString = "Sexta";
        else if (getFreqDiaria() == 6) diaString = "Sábado";
        else if (getFreqDiaria() == 7) diaString = "Domingo";

        string += "Agenda de Pagamento: " + getTipoCronograma() + "    Dia da semana: " + diaString;
        string += "\n_________________________________________________________________________________________________________\n";

        if (getIsSindicato() == 1)
        {
            string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicato().getSindicatoTax();
            string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicato().getValorTaxaServico();
        }

        string += "\nComissão de vendas -------------------------------------------------------- (+) R$ " + this.valorComissao;
        string += "\n\nSalário Líquido  -------------------------------------------------------------- R$ " + this.getSalarioComissionadoLiq();

        return string;
    }
}











