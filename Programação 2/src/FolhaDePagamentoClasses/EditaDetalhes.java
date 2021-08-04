package FolhaDePagamentoClasses;

import java.util.ArrayList;
import ClassesFuncionario.Assalariado;
import ClassesFuncionario.Comissionados;
import ClassesFuncionario.Horistas;
import ClassesFuncionario.Funcionario;

public class EditaDetalhes
{
    public static void alterTipo(ArrayList<Funcionario> listaFuncionario, int item)
    {
        Funcionario novoFuncionario = null;

        System.out.println("Escolha o tipo do empregado:");
        System.out.println("(1) - Horista");
        System.out.println("(2) - Assalariado");
        System.out.println("(3) - Comissionado");
        int tipo = Excecoes.readInt();

        if(tipo == 1)
        {
            novoFuncionario = new Horistas(listaFuncionario.get(item).getFuncionarioId(), listaFuncionario.get(item).getNome(),
                    listaFuncionario.get(item).getEndereco(), listaFuncionario.get(item).getMetodoPag(), listaFuncionario.get(item).getIsSindicato(),
                    tipo, listaFuncionario.get(item).getTipoCronograma(), listaFuncionario.get(item).getFreqDiaria());

            novoFuncionario.salario();

            if(listaFuncionario.get(item).getIsSindicato() == 1)
            {
                novoFuncionario.getSindicato().setSindicatoId(listaFuncionario.get(item).getSindicato().getSindicatoId());
                novoFuncionario.getSindicato().setSindicatoTax(listaFuncionario.get(item).getSindicato().getSindicatoTax());
            }

        }
        else if (tipo == 2)
        {
            novoFuncionario = new Assalariado(listaFuncionario.get(item).getFuncionarioId(), listaFuncionario.get(item).getNome(),
                    listaFuncionario.get(item).getEndereco(), listaFuncionario.get(item).getMetodoPag(), listaFuncionario.get(item).getIsSindicato(),
                    tipo, listaFuncionario.get(item).getTipoCronograma(), listaFuncionario.get(item).getFreqDiaria());

            novoFuncionario.salario();

            if (listaFuncionario.get(item).getIsSindicato() == 1)
            {
                novoFuncionario.getSindicato().setSindicatoId(listaFuncionario.get(item).getSindicato().getSindicatoId());
                novoFuncionario.getSindicato().setSindicatoTax(listaFuncionario.get(item).getSindicato().getSindicatoTax());
            }


        }
        else if (tipo == 3)
        {
            novoFuncionario = new Comissionados(listaFuncionario.get(item).getFuncionarioId(), listaFuncionario.get(item).getNome(),
                    listaFuncionario.get(item).getEndereco(), listaFuncionario.get(item).getMetodoPag(), listaFuncionario.get(item).getIsSindicato(),
                    tipo, listaFuncionario.get(item).getTipoCronograma(), listaFuncionario.get(item).getFreqDiaria());

            novoFuncionario.salario();

            if (listaFuncionario.get(item).getIsSindicato() == 1)
            {
                novoFuncionario.getSindicato().setSindicatoId(listaFuncionario.get(item).getSindicato().getSindicatoId());
                novoFuncionario.getSindicato().setSindicatoTax(listaFuncionario.get(item).getSindicato().getSindicatoTax());
            }
        }

        listaFuncionario.add(novoFuncionario);
        listaFuncionario.remove(item);

        System.out.println("\nTipo do empregado alterado com sucesso!");

    }
}
