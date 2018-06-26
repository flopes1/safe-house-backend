package com.poli.sh.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poli.sh.dao.def.IVisitSchedulerDao;
import com.poli.sh.dao.util.GenericDao;
import com.poli.sh.model.AgendamentoVisita;

/**
 * 
 * @author Filipe Mendes
 *
 */

@Repository
public class VisitSchedulerDao implements IVisitSchedulerDao
{

    private static final Logger log = LoggerFactory.getLogger(VisitSchedulerDao.class);

    @Autowired
    private GenericDao<AgendamentoVisita> agendamentoDao;

    @PostConstruct
    public void initDao()
    {
        log.info("Initializing generic repository access");
        this.agendamentoDao.setClassType(AgendamentoVisita.class);
        log.info("Generic repository initialized with entity :" + AgendamentoVisita.class.getName());
    }

    @Override
    public void add(AgendamentoVisita agendamentoVisita)
    {
        this.agendamentoDao.addEntity(agendamentoVisita);
    }

    @Override
    public void remove(Integer id)
    {
        this.agendamentoDao.removeEntityById(id);
    }

    @Override
    public AgendamentoVisita update(AgendamentoVisita agendamentoVisita)
    {
        return this.agendamentoDao.updateEntity(agendamentoVisita);
    }

    @Override
    public List<AgendamentoVisita> getByUserId(Integer id)
    {
        return this.agendamentoDao.getEntitiesByEntityColumn("usuario", id);
    }

    @Override
    public List<AgendamentoVisita> getByCondominiumId(Integer id)
    {
        return this.agendamentoDao.getEntitiesByEntityColumn("condominio", id);
    }

}
