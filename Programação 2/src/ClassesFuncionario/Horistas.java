package ClassesFuncionario;

import java.util.ArrayList;
import FolhaDePagamentoClasses.Excecoes;

public class Horistas extends Funcionario
{
    public Horistas(int funcionarioId, String nome, String endereco, int tipo, int isSindicato, int metodoPag, String tipoCronograma, int freqDiaria)
    {
        super(funcionarioId, nome, endereco, tipo, isSindicato, metodoPag, tipoCronograma, freqDiaria);
    }

    private double salarioHoristasLiq = 0;
    private double salarioHoristas = 0;
    private double salarioHora = 0;

    @Override
    public void salario()
    {
        System.out.println("Digite o salário por hora Trabalhada:\nExemplo: X,X ou X\nR$: ");
        double salarioTemp = Excecoes.readDouble();

        this.salarioHora = salarioTemp;
    }

    @Override
    public void pagFuncionario(ArrayList<Funcionario> funcionario, int index)
    {
        this.salarioHoristasLiq = salarioHoristas - getSindicato().getSindicatoTax() - getSindicato().getValorTaxaServico();
        System.out.println(funcionario.get(index).toString() + "\n");

        this.salarioHoristasLiq = 0;
        this.salarioHoristas = 0;
    }

    public void CartaoDePonto()
    {
        System.out.println("\nHorário Entrada:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
        int CartaoDePontoEnt = Excecoes.readInt();

        System.out.println("\nHorário Saída:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
        int CartaoDePontoSai = Excecoes.readInt();

        System.out.println("Cartão de Ponto do Empregado resgitrado com Sucesso!\n");
    }

    public static double CalcSalario (double salarioHora, int entrada, int saida)
    {
        double salario;

        int horaTrab = saida - entrada;
        float minutos = horaTrab % 100;

        if(horaTrab <= 800)
        {
            if(minutos < 10)
            {
                minutos = minutos / 10;
            }
            else
            {
                minutos = minutos / 100;
            }

            salario = ((horaTrab/100) * salarioHora) + (minutos * salarioHora);
        }
        else
        {
            int horaExtra = horaTrab - 800;

            if(minutos < 10)
            {
                minutos = minutos / 10;
            }
            else
            {
                minutos = minutos / 100;
            }

            salario = (8 * salarioHora + ((horaExtra/100) * (salarioHora * 1.5)) + (minutos * (horaExtra * 1.5)));
        }
        return salario;
    }


    public double getSalarioHoristas()
    {
        return salarioHoristas;
    }

    @Override
    public String toString()
    {
        String string, diaString = null;

        string = super.toString();

        string += "Tipo: Horista      Salário Hora: R$ " + this.salarioHora;
        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (getFreqDiaria() == 1) diaString = "Segunda";
        else if (getFreqDiaria() == 2) diaString = "Terça";
        else if (getFreqDiaria() == 3) diaString = "Quarta";
        else if (getFreqDiaria() == 4) diaString = "Quinta";
        else if (getFreqDiaria() == 5) diaString= "Sexta";
        else if (getFreqDiaria() == 6) diaString = "Sábado";
        else if (getFreqDiaria() == 7) diaString = "Domingo";

        string += "Agenda de Pagamento: " + this.getTipoCronograma() + "   Dia da semana: " + diaString;
        string += "\n________________________________________________________________________________________________________\n";

        if (getIsSindicato() == 1)
        {
            string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicato().getSindicatoTax();
            string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicato().getValorTaxaServico();
        }

        string += "\nSalário  Bruto Acumulado -------------------------------------------------- (+) R$ " + this.salarioHoristas;
        string += "\n\nSalário Líquido --------------------------------------------------------------- R$ " + this.salarioHoristasLiq;

        return string;
    }
}