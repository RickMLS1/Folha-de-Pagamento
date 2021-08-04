package FolhaDePagamentoClasses;

public class Main
{

    static CalendarioPag calendario = new CalendarioPag();

    public static void main(String[] args)
    {

        Funcionalidades funcionalidades = new Funcionalidades();

        while (true)
        {

            int dia = calendario.getDia();
            int diaSemana = calendario.getDiaSemana();
            int semana = calendario.getSemana();
            int mes = calendario.getMes();
            int ano = calendario.getAno();
            int ultimoDia = calendario.ultimoDia(mes);

            menu();

            int opcao = Excecoes.readInt();

            switch(opcao)
            {
                case 1:
                    funcionalidades.addFuncionario();
                    break;

                case 2:
                    funcionalidades.removeFuncionario();
                    break;

                case 3:
                    funcionalidades.launchCartaoDePonto();
                    break;

                case 4:
                    funcionalidades.launchVendasResult();
                    break;

                case 5:
                    funcionalidades.launchTaxaServico();
                    break;

                case 6:
                    funcionalidades.alterDetalhes();
                    break;

                case 7:
                    funcionalidades.playFolhaDePag(dia, diaSemana, semana, ultimoDia);
                    calendario.advanceDay();

                    System.out.println("\nData: " + dia + "/ " + mes + " / " + ano + " -  Folha de pagamento executada com sucesso!\n");
                    break;

                case 8:
                    System.out.println("Não temos essa funcionalidade no momento...");
                    break;

                case 9:
                    funcionalidades.CronogramaDePagamento();
                    break;

                case 10:
                    funcionalidades.novoCronograma();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("\nErro: Opção Inválida.\n");
            }

        }
    }

    public static void menu()
    {
        System.out.println("=============================== FOLHA DE PAGAMENTO =====================================");

        System.out.println(calendario.toString());

        System.out.println("\nEscolha uma opção:");
        System.out.println("(1) - Adicionar Empregado");
        System.out.println("(2) - Remover Empregado");
        System.out.println("(3) - Lançar um Cartão de Ponto");
        System.out.println("(4) - Lançar um Resultado de Venda");
        System.out.println("(5) - Lançar uma Taxa de Serviço");
        System.out.println("(6) - Alterar Detalhes de um Empregado");
        System.out.println("(7) - Rodar a Folha de Pagamento para Hoje (após rodar, avança 1 dia)");
        System.out.println("(8) - Undo/redo");
        System.out.println("(9) - Agenda de Pagamento");
        System.out.println("(10) - Criação de Novas Agendas de Pagamento");
        System.out.println("(0) - Sair");
    }
}
