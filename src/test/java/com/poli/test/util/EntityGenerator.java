package com.poli.test.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.poli.sh.model.AgendamentoVisita;
import com.poli.sh.model.Condominio;
import com.poli.sh.model.Usuario;
import com.poli.sh.model.Visitante;

public class EntityGenerator
{

    public static Usuario getExistingUser(Integer id)
    {
        Usuario user = new Usuario();
        user.setId(1);

        return user;
    }

    public static Condominio getExistingCondominio(Integer id)
    {
        Condominio condominio = new Condominio();
        condominio.setId(1);

        return condominio;
    }

    public static AgendamentoVisita getAgendamento()
    {
        AgendamentoVisita agendamentoVisita = new AgendamentoVisita();
        agendamentoVisita.setData(new Date());
        agendamentoVisita.setVisitantes(getListVisitante(3));
        agendamentoVisita.setCondominio(getExistingCondominio(1));
        agendamentoVisita.setUsuario(getExistingUser(1));

        return agendamentoVisita;
    }

    private static List<Visitante> getListVisitante(int number)
    {
        List<Visitante> visitantes = new ArrayList<Visitante>();

        for (int i = 1; i < number + 1; i++)
        {
            visitantes.add(getVisitante(String.valueOf(i)));
        }
        return visitantes;
    }

    private static Visitante getVisitante()
    {
        return getVisitante("");
    }

    private static Visitante getVisitante(String sufix)
    {
        Visitante visitante = new Visitante();
        visitante.setNome("Nome do Visitante" + sufix);

        return visitante;
    }

}
