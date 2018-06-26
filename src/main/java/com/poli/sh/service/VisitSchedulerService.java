package com.poli.sh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poli.sh.dao.def.IVisitSchedulerDao;
import com.poli.sh.model.AgendamentoVisita;
import com.poli.sh.service.def.IVisitSchedulerService;

/* 
* @author Filipe Mendes
*
*/

@Service
@Transactional
public class VisitSchedulerService implements IVisitSchedulerService
{

    // private static final Logger log = LoggerFactory.getLogger(VisitSchedulerService.class);

    @Autowired
    private IVisitSchedulerDao visitSchedulerDao;

    @Override
    public void add(AgendamentoVisita agendamentoVisita)
    {
        this.visitSchedulerDao.add(agendamentoVisita);
    }

    @Override
    public void remove(Integer id)
    {
        this.visitSchedulerDao.remove(id);
    }

    @Override
    public AgendamentoVisita update(AgendamentoVisita agendamentoVisita)
    {
        return this.visitSchedulerDao.update(agendamentoVisita);
    }

    @Override
    public List<AgendamentoVisita> getByUserId(Integer id)
    {
        return this.visitSchedulerDao.getByUserId(id);
    }

    @Override
    public List<AgendamentoVisita> getByCondominiumId(Integer id)
    {
        return this.visitSchedulerDao.getByCondominiumId(id);
    }

}
