package FolhaDePagamentoClasses;

public class CalendarioPag
{
    private int diaSemana = 1;
    private int dia = 1;
    private int semana = 1;
    private int mes = 1;
    private int ano = 2021;
    private String diaString = "Segunda";

    public void advanceDay()
    {
        this.dia++;
        this.diaSemana++;
        this.semana = (dia / 7) + 1;

        if (diaSemana == 8)
        {
            this.diaSemana = 1;
        }

        if (this.mes == 2 & this.dia == 29)
        {
            this.dia = 1;
            this.semana = 1;
            this.mes++;
        }

        if (this.dia == 32)
        {
            if (this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12)
            {
                if (this.mes == 12)
                {
                    this.dia = 1;
                    this.semana = 1;
                    this.mes = 1;
                    this.ano++;
                }
                else
                {
                    this.dia = 1;
                    this.semana = 1;
                    this.mes++;
                }
            }
        }
        else if (this.dia == 31)
        {
            if (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11)
            {
                this.dia = 1;
                this.semana = 1;
                this.mes++;
            }
        }

        if (diaSemana == 1) diaString = "Segunda";
        else if (diaSemana == 2) diaString = "Terça";
        else if (diaSemana == 3) diaString = "Quarta";
        else if (diaSemana == 4) diaString = "Quinta";
        else if (diaSemana == 5) diaString = "Sexta";
        else if (diaSemana == 6) diaString = "Sábado";
        else if (diaSemana == 7) diaString = "Domingo";
    }

    public int ultimoDia(int mes)
    {
        int ultimo = 0;

        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
        {
            ultimo = 31;
        }
        else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
        {
            ultimo = 30;
        }
        else if (mes == 2)
        {
            ultimo = 28;
        }

        return ultimo;
    }

    @Override
    public String toString()
    {

        return this.diaString + " - Dia: " + this.dia + " Mês: " + this.mes + " Ano: " + this.ano;
    }

    public int getDiaSemana()
    {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana)
    {
        this.diaSemana = diaSemana;
    }

    public int getDia()
    {
        return dia;
    }

    public void setDia(int dia)
    {
        this.dia = dia;
    }

    public int getSemana()
    {
        return semana;
    }

    public void setSemana(int semana)
    {
        this.semana = semana;
    }

    public int getMes()
    {
        return mes;
    }

    public void setMes(int mes)
    {
        this.mes = mes;
    }

    public int getAno()
    {
        return ano;
    }

    public void setAno(int ano)
    {
        this.ano = ano;
    }
}
