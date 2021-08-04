package FolhaDePagamentoClasses;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excecoes
{
    private static Scanner input;

    public static int readInt()
    {
        input = new Scanner(System.in);

        while(true)
        {
            try
            {
                int valor = input.nextInt();
                return valor;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Aconteceu um Erro. Entrada inválida. Por favor, digite um valor inteiro");
            }
            finally
            {
                input.nextLine();
            }
        }
    }

    public static double readDouble()
    {
        input = new Scanner(System.in);

        while (true)
        {
            try
            {
                double valor = input.nextDouble();
                return valor;

            }
            catch (InputMismatchException e)
            {
                System.out.println("Aconteceu um erro. Entrada inválida. Por favor, digite um valor double");
            }
            finally
            {
                input.nextLine();
            }
        }

    }
}
