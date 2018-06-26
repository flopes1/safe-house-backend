package com.poli.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.poli.sh.config.DatabaseConfiguration;
import com.poli.sh.dao.def.IVisitSchedulerDao;
import com.poli.sh.model.AgendamentoVisita;
import com.poli.test.util.EntityGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ DatabaseConfiguration.class })
@Transactional
@WebAppConfiguration
public class AgendamentoVisitaDaoTest
{

    @Autowired
    private IVisitSchedulerDao agendamentoVisitaDAO;

    @Test
    @Rollback(false)
    public void add()
    {
        try
        {
            // AgendamentoVisita agendamentoVisita = EntityGenerator.getAgendamento();
            // this.agendamentoVisitaDAO.add(agendamentoVisita);
        }
        catch (Exception e)
        {
            fail();
        }
    }

    @Test
    @Rollback(false)
    public void update()
    {
        try
        {
            // List<AgendamentoVisita> agendamentoVisita = this.agendamentoVisitaDAO.getByCondiminiumId(1);
            // AgendamentoVisita agendamento = agendamentoVisita.get(0);
            // agendamento.setDescricao("Visita de amigos3");
            // agendamento.getVisitantes().remove(1);
            // AgendamentoVisita updated = this.agendamentoVisitaDAO.update(agendamento);
            // assertEquals("Visita de amigos 3", updated.getDescricao());
            // assertEquals(agendamento.getVisitantes().size() - 1, updated.getVisitantes().size());
        }
        catch (Exception e)
        {
            fail();
        }
    }

    @Test
    @Rollback(false)
    public void remove()
    {
        try
        {
            // this.agendamentoVisitaDAO.remove(3);
            // List<AgendamentoVisita> agendamentoVisita = this.agendamentoVisitaDAO.getByCondiminiumId(3);
            // assertEquals(0, agendamentoVisita.size());
        }
        catch (Exception e)
        {
            fail();
        }
    }

    @Test
    public void getByUser()
    {
        try
        {
            // List<AgendamentoVisita> agendamentos = this.agendamentoVisitaDAO.getByCondiminiumId(1);
            // assertEquals(true, agendamentos != null);
        }
        catch (Exception e)
        {
            fail();
        }
    }

}
