package FolhaDePagamentoClasses;

import java.util.ArrayList;
import ClassesFuncionario.Funcionario;

public class Cronograma
{
    public int procuraFuncionario(ArrayList<Funcionario> listaFuncionario, int numFuncionario)
    {
        int item;

        if (listaFuncionario.isEmpty()) {
            System.out.println("\nDesculpe, encontramos um erro. Não há empregados cadastrados.");
            return -1;
        } else {
            for (item = 0; item < listaFuncionario.size(); item++) {
                if (listaFuncionario.get(item).getFuncionarioId() == numFuncionario) {
                    break;
                }
            }
        }
        return item;
    }

    public void cronogConsul(ArrayList<Funcionario> listaFuncionario)
    {
        if(listaFuncionario.isEmpty())
        {
            System.out.println("\nDesculpe, encontramos um erro. Não há empregados cadastrados.");
            return;
        }
        else
        {
            for(int item = 0; item < listaFuncionario.size(); item++)
            {
                System.out.println(listaFuncionario.get(item).toString() + "\n\n");
            }
        }
    }

    public void novoCronograma(ArrayList<Funcionario> listaFuncionario, int index)
    {
        String cronograma = null;

        System.out.println("\nPor favor, escolha uma opção:");
        System.out.println("(1) Mensal");
        System.out.println("(2) Semanal");
        int option = Excecoes.readInt();

        if(option == 1)
        {
            System.out.println("\nEscolha o dia ou digite -1 para o último dia do mês");
            int option2 = Excecoes.readInt();

            listaFuncionario.get(index).setTipoCronograma("Mensal");

            if (option2 == -1)
            {
                listaFuncionario.get(index).setFreqDiaria(30);
            }
            else
            {
                listaFuncionario.get(index).setFreqDiaria(option2);
            }
        }
        else if (option == 2)
        {
            System.out.println("\nEscolha a frequencia:\n(1)  Toda semana\n(2) A cada duas semanas\n(3) A cada três semanas\n");
            int option2 = Excecoes.readInt();

            if (option2 == 1) cronograma = "1 - Semanal";
            else if (option2 == 2) cronograma = "2 - Semanal";
            else if (option2 == 3) cronograma = "3 - Semanal";

            listaFuncionario.get(index).setTipoCronograma(cronograma);

            System.out.println("\nEscolha o dia da semana:\n(1) Segunda\n(2) Terça\n(3) Quarta\n(4) Quinta\n(5) Sexta");
            int option3 = Excecoes.readInt();

            listaFuncionario.get(index).setFreqDiaria(option3);
        }

        System.out.println("\nNova agenda de pagamento criada com sucesso!\n");
    }
}
