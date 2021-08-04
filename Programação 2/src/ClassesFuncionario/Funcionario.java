package ClassesFuncionario;

import java.util.ArrayList;
import java.util.Scanner;
import FolhaDePagamentoClasses.Excecoes;

public abstract class Funcionario
{
    private int funcionarioId;
    private String nome;
    private String endereco;
    private int tipo;
    private int isSindicato = 0;
    private int metodoPag;

    // Variaveis da Agenda
    private String tipoCronograma;
    private int freqDiaria;

    Sindicato sindicato = new Sindicato();
    static Scanner input = new Scanner(System.in);

    public Funcionario(int funcionarioId, String nome, String endereco, int tipo, int isSindicato, int metodoPag, String tipoCronograma, int freqDiaria)
    {
        this.funcionarioId = funcionarioId;
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.isSindicato = isSindicato;
        this.metodoPag = metodoPag;
        this.tipoCronograma = tipoCronograma;
        this.freqDiaria = freqDiaria;
    }

    public void editDetalhes(int op)
    {
        switch(op)
        {
            case 1:
                System.out.println("Digite por favor o novo nome do Empregado");
                String nome = input.nextLine();
                setNome(nome);
                System.out.println("Nome do Empregado alterado com sucesso!");

            case 2:
                System.out.println("Digite por favor o novo Endereço do Empregado");
                String endereco = input.nextLine();
                setEndereco(endereco);
                System.out.println("Endereço do Empregado alterado com sucesso!");

            case 3:
                System.out.println("Método de Pagamento:");
                System.out.println("(1) Cheque pelos Correios");
                System.out.println("(2) Cheque em Mãos");
                System.out.println("(3) Depósito em Conta");

                int metodoPag = Excecoes.readInt();
                setMetodoPag(metodoPag);

                System.out.println("Método de Pagamento do Empregado alterado com sucesso!");

            case 4:
                System.out.println("O Empregado pertence ao Sindicato?");
                System.out.println("(1) Sim");
                System.out.println("(2) Não");

                int isSindicato = Excecoes.readInt();
                setIsSindicato(isSindicato);

                if(isSindicato == 1)
                {
                    System.out.println("Digite o valor da taxa Sindical:\nR$: ");

                    double sindicalTax = Excecoes.readDouble();

                    sindicato.setSindicatoId(getFuncionarioId());
                    sindicato.setSindicatoTax(sindicalTax);
                    setFuncionarioId(getFuncionarioId() + 1);
                }

                System.out.println("Sindicato do Empregado alterado com sucesso!");

                break;

        }
    }

    public abstract void salario();
    public abstract void pagFuncionario(ArrayList<Funcionario> funcionario, int index);

    public int getFuncionarioId()
    {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId)
    {
        this.funcionarioId = funcionarioId;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public int getTipo()
    {
        return tipo;
    }

    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }

    public int getIsSindicato()
    {
        return isSindicato;
    }

    public void setIsSindicato(int isSindicato)
    {
        this.isSindicato = isSindicato;
    }

    public int getMetodoPag()
    {
        return metodoPag;
    }

    public void setMetodoPag(int metodoPag)
    {
        this.metodoPag = metodoPag;
    }

    public String getTipoCronograma()
    {
        return tipoCronograma;
    }

    public void setTipoCronograma(String tipoCronograma)
    {
        this.tipoCronograma = tipoCronograma;
    }

    public int getFreqDiaria()
    {
        return freqDiaria;
    }

    public void setFreqDiaria(int freqDiaria)
    {
        this.freqDiaria = freqDiaria;
    }

    public Sindicato getSindicato()
    {
        return sindicato;
    }

    public void setSindicato(Sindicato sindicato)
    {
        this.sindicato = sindicato;
    }

    @Override
    public String toString()
    {
        String string;

        string = "Número Empregado: " + this.funcionarioId + "		Nome: " + this.nome;
        string += "\n--------------------------------------------------------------------------------------------------------\n";
        string += "Endereço: " + this.endereco;
        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (this.metodoPag == 1)
        {
            string += "Método de Pagamento: Cheque pelos correios";
        }
        else if (this.metodoPag == 2)
        {
            string += "Método de Pagamento: Cheque em mãos";
        }
        else if (this.metodoPag == 3)
        {
            string += "Método de Pagamento: Depósito em conta bancária";
        }

        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (isSindicato == 1)
        {
            string += "Sindicado: Pertence		Número do Sindicato: " + this.sindicato.getSindicatoId() + "		Taxa Sindical: R$ " + this.sindicato.getSindicatoTax();
        }
        else
        {
            string += "Sindicado: Não Pertence";
        }

        string += "\n--------------------------------------------------------------------------------------------------------\n";

        return string;
    }
}
