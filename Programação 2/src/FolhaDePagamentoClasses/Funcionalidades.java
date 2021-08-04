package FolhaDePagamentoClasses;

import java.util.ArrayList;
import java.util.Scanner;

import ClassesFuncionario.Assalariado;
import ClassesFuncionario.Comissionados;
import ClassesFuncionario.Horistas;
import ClassesFuncionario.Funcionario;

public class Funcionalidades
{
    static Scanner input = new Scanner(System.in);

    private static int funcionarioId = 1, sindicatoId = 1;
    private static double sindicalTax = 0;

    static ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
    Cronograma cronograma = new Cronograma();

    public void addFuncionario()
    {
        System.out.println("** Adicionando um Empregado **\n");

        System.out.println("Digite o nome do Empregado:");
        String nome = input.nextLine();

        System.out.println("\nDigite o endereço do Empregado");
        String endereco = input.nextLine();

        System.out.println("\nMétodo de Pagamento do Empregado:");
        System.out.println("(1) - Cheque pelos Correios");
        System.out.println("(2) - Cheque em Mãos");
        System.out.println("(3) - Depósito em Conta");
        int metodoPag = Excecoes.readInt();

        System.out.println("\nO Empregado pertence a um Sindicato?");
        System.out.println("(1) - Sim");
        System.out.println("(0) - Não");
        int isSindicato = Excecoes.readInt();

        if(isSindicato == 1)
        {
            System.out.println("\nDigite o valor da Taxa Sindical:\nR$: ");
            sindicalTax = Excecoes.readDouble();
        }

        System.out.println("\nQual é o tipo de Empregado:");
        System.out.println("(1) - Horista");
        System.out.println("(2) - Assalariado");
        System.out.println("(3) - Comissionado");
        int tipoFuncionario = Excecoes.readInt();

        if(tipoFuncionario == 1)
        {
            Horistas horistas = new Horistas(funcionarioId, nome, endereco, metodoPag, isSindicato, tipoFuncionario, "1 - Semanal", 5);

            horistas.salario();

            if(isSindicato == 1)
            {
                horistas.getSindicato().setSindicatoId(sindicatoId);
                horistas.getSindicato().setSindicatoTax(sindicalTax);
                sindicatoId++;
            }

            listaFuncionario.add(horistas);
        }
        else if(tipoFuncionario == 2)
        {
            Assalariado assalariado = new Assalariado(funcionarioId, nome, endereco, metodoPag, isSindicato, tipoFuncionario, "Semanal", 31);


            assalariado.salario();

            if(isSindicato == 1)
            {
                assalariado.getSindicato().setSindicatoId(sindicatoId);
                assalariado.getSindicato().setSindicatoTax(sindicalTax);
                sindicatoId++;
            }

            listaFuncionario.add(assalariado);
        }
        else if(tipoFuncionario == 3)
        {
            Comissionados comissionados = new Comissionados(funcionarioId, nome, endereco, metodoPag, isSindicato, tipoFuncionario, "2 - Semanal", 5);

            comissionados.salario();

            if (isSindicato == 1)
            {
                comissionados.getSindicato().setSindicatoId(sindicatoId);
                comissionados.getSindicato().setSindicatoTax(sindicalTax);
                sindicatoId++;
            }

            listaFuncionario.add(comissionados);
        }
        else
        {
            System.out.println("\nErro: Opção Inválida.\\n");
        }

        System.out.println("\nEmpregado foi cadastrado com sucesso!\n");

        funcionarioId++;
    }

    public void removeFuncionario()
    {
        System.out.println("** Removendo um Empregado **\n");

        System.out.println("Digite o número do Empregado: ");
        int funcionarioIdTemp = Excecoes.readInt();

        int index = cronograma.procuraFuncionario(listaFuncionario, funcionarioIdTemp);

        if(index == -1)
        {
            // Colocar Retorno
            return;
        }
        else
        {
            listaFuncionario.remove(index);
            System.out.println("\nEmpregado foi removido com sucesso!\n");
        }
    }

    public void launchCartaoDePonto()
    {
        System.out.println("** Lançando um Cartão de Ponto do Empregado **");
        System.out.println("Digite o número do Empregado: ");
        int funcionarioIdTemp = Excecoes.readInt();

        int index = cronograma.procuraFuncionario(listaFuncionario, funcionarioIdTemp);

        try
        {
            if (index == -1) return;

            Horistas horistas = (Horistas) listaFuncionario.get(index);
            horistas.CartaoDePonto();

        }
        catch (Exception e)
        {
            System.out.println("\nErro: Empregado não é horista.\n");
        }
    }

    public void launchVendasResult()
    {
        System.out.println("\n** Lançando um resultado de Venda de um Empregado **\n");
        System.out.println("Digite o número do Empregado:");
        int funcinarioIdTemp = Excecoes.readInt();

        int index = cronograma.procuraFuncionario(listaFuncionario, funcinarioIdTemp);

        try
        {
            if (index == -1) return;

            Comissionados comissionados = (Comissionados) listaFuncionario.get(index);
            comissionados.vendasResult();

        }
        catch (Exception e)
        {
            System.out.println("\nErro: Empregado não é comissionado.\n");
        }
    }

    public void launchTaxaServico()
    {
        System.out.println("\n** Lançando uma taxa de Serviço de um Empregado **\n");
        System.out.println("Digite o número do Empregado:");
        int funcinarioIdTemp = Excecoes.readInt();

        int index = cronograma.procuraFuncionario(listaFuncionario, funcinarioIdTemp);
        if (index == -1) return;

        if (listaFuncionario.get(index).getIsSindicato() == 1)
        {
            listaFuncionario.get(index).getSindicato().servicoTax();

        }
        else
        {
            System.out.println("\nErro: Empregado não pertence ao sindicato.\n");
        }
    }

    public void alterDetalhes()
    {
        System.out.println("\n** Alterando os dados de um usuário **\n");
        System.out.println("Digite o número do Empregado:");
        int funcinarioIdTemp = Excecoes.readInt();

        int index = cronograma.procuraFuncionario(listaFuncionario, funcinarioIdTemp);
        if (index == -1) return;

        System.out.println("Escolha uma opção:");
        System.out.println("(1) - Alterar Nome");
        System.out.println("(2) - Alterar Endereço");
        System.out.println("(3) - Alterar Método de Pagamento");
        System.out.println("(4) - Alterar Sindicato");
        System.out.println("(5) - Alterar Tipo");

        int option = Excecoes.readInt();

        if (option <=4 & option > 0) {
            listaFuncionario.get(index).editDetalhes(option);

        }
        else if(option == 5)
        {
            EditaDetalhes.alterTipo(listaFuncionario, index);

        }
        else
        {
            System.out.println("\nErro: Opção Inválida.\n");
        }
    }
    public void playFolhaDePag(int day, int dayWeek, int week, int last)
    {
        System.out.println("\n** Rodando a Folha de Pagamento **\n");
        System.out.println("Verificando empregados...\n");

        for (int i=0; i < listaFuncionario.size(); i++) {

            if ((listaFuncionario.get(i).getTipoCronograma() == "1 - Semanal") && (listaFuncionario.get(i).getFreqDiaria() == dayWeek))
            {

                listaFuncionario.get(i).pagFuncionario(listaFuncionario, i);

            }
            else if ((listaFuncionario.get(i).getTipoCronograma() == "2 - Semanal") && (listaFuncionario.get(i).getFreqDiaria() == dayWeek)
                    && (week == 2 || week == 4))
            {

                listaFuncionario.get(i).pagFuncionario(listaFuncionario, i);

            }
            else if ((listaFuncionario.get(i).getTipoCronograma() == "3 - Semanal") && (listaFuncionario.get(i).getFreqDiaria() == dayWeek)
                    && (week == 3))
            {

                listaFuncionario.get(i).pagFuncionario(listaFuncionario, i);

            }
            else if (listaFuncionario.get(i).getTipoCronograma() == "Mensal")
            {

                if (listaFuncionario.get(i).getFreqDiaria() == 28 || listaFuncionario.get(i).getFreqDiaria() == 30
                        || listaFuncionario.get(i).getFreqDiaria() == 31)
                {
                    // Verifica se o dia na agenda não foi alterado
                    listaFuncionario.get(i).setFreqDiaria(last);
                }

                if (listaFuncionario.get(i).getFreqDiaria() == day)
                {
                    listaFuncionario.get(i).pagFuncionario(listaFuncionario, i);

                }
            }
        }

    }

    public void CronogramaDePagamento()
    {
        System.out.println("\n** Agenda de Pagamento **\n");

        cronograma.cronogConsul(listaFuncionario);
    }

    public void novoCronograma()
    {
        System.out.println("\n** Criando Agenda de Pagamento **\n");
        System.out.println("Digite o número do Empregado:");
        int nEmpTemp = Excecoes.readInt();

        int index = cronograma.procuraFuncionario(listaFuncionario, nEmpTemp);
        if (index == -1) return;

        cronograma.novoCronograma(listaFuncionario, index);
    }

    public static int getSindicatoId()
    {
        return sindicatoId;
    }

    public static void setSindicatoId(int sindicatoId)
    {
        Funcionalidades.sindicatoId = sindicatoId;
    }
}
