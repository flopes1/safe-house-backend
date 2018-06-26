package com.poli.sh.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poli.sh.dao.def.ICondominiumDao;
import com.poli.sh.dao.util.GenericDao;
import com.poli.sh.model.Condominio;

@Repository
public class CondominiumDao implements ICondominiumDao
{

    private static final Logger log = LoggerFactory.getLogger(CondominiumDao.class);

    @Autowired
    private GenericDao<Condominio> condominioDao;

    @PostConstruct
    public void initDao()
    {
        log.info("Initializing generic repository access");
        this.condominioDao.setClassType(Condominio.class);
        log.info("Generic repository initialized with entity :" + Condominio.class.getName());
    }

    @Override
    public void add(Condominio condominio)
    {
        this.condominioDao.addEntity(condominio);
    }

    @Override
    public Condominio getById(Integer id)
    {
        return this.condominioDao.getEntityById(id);
    }

    @Override
    public Condominio update(Condominio condominio)
    {
        return this.condominioDao.updateEntity(condominio);
    }

    @Override
    public void remove(Integer id)
    {
        this.condominioDao.removeEntityById(id);
    }

    @Override
    public List<Condominio> getAll()
    {
        return this.condominioDao.getAllEntities();
    }

}
