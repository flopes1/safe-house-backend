package com.poli.sh.service.def;

import java.util.List;

import com.poli.sh.model.AgendamentoVisita;

public interface IVisitSchedulerService
{
    
    void add(AgendamentoVisita agendamentoVisita);

    void remove(Integer id);

    AgendamentoVisita update(AgendamentoVisita agendamentoVisita);

    List<AgendamentoVisita> getByUserId(Integer id);

    List<AgendamentoVisita> getByCondominiumId(Integer id);

}
