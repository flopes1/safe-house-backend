package com.poli.sh.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poli.sh.dao.def.IAutenticationDao;
import com.poli.sh.dao.util.GenericDao;
import com.poli.sh.model.PedidoAutenticacao;

@Repository
public class AutenticationDao implements IAutenticationDao
{

    private static final Logger log = LoggerFactory.getLogger(AutenticationDao.class);

    @Autowired
    private GenericDao<PedidoAutenticacao> pedidoAutenticacaoDao;

    @PostConstruct
    public void initDao()
    {
        log.info("Initializing generic repository access");
        this.pedidoAutenticacaoDao.setClassType(PedidoAutenticacao.class);
        log.info("Generic repository initialized with entity :" + PedidoAutenticacao.class.getName());
    }

    @Override
    public void add(PedidoAutenticacao pedidoAutenticacao)
    {
        this.pedidoAutenticacaoDao.addEntity(pedidoAutenticacao);
    }

    @Override
    public void remove(Integer id)
    {
        this.pedidoAutenticacaoDao.removeEntityById(id);
    }

    @Override
    public PedidoAutenticacao getById(Integer id)
    {
        return this.pedidoAutenticacaoDao.getEntityById(id);
    }

    @Override
    public List<PedidoAutenticacao> getByCondominiumId(Integer id)
    {
        return this.pedidoAutenticacaoDao.getEntitiesByEntityColumn("idCond", id);
    }

}
