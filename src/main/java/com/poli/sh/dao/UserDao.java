package com.poli.sh.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poli.sh.dao.def.IUserDao;
import com.poli.sh.dao.util.GenericDao;
import com.poli.sh.model.Usuario;

/* 
* @author Filipe Mendes
*
*/

@Repository
public class UserDao implements IUserDao
{

    private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private GenericDao<Usuario> usuarioDao;

    @PostConstruct
    public void initDao()
    {
        log.info("Initializing generic repository access");
        this.usuarioDao.setClassType(Usuario.class);
        log.info("Generic repository initialized with entity :" + Usuario.class.getName());
    }

    @Override
    public void add(Usuario usuario)
    {
        this.usuarioDao.addEntity(usuario);
    }

    @Override
    public void remove(Integer id)
    {
        this.usuarioDao.removeEntityById(id);
    }

    @Override
    public Usuario getById(Integer id)
    {
        return this.usuarioDao.getEntityById(id);
    }

    @Override
    public Usuario update(Usuario usuario)
    {
        return this.usuarioDao.updateEntity(usuario);
    }

    @Override
    public List<Usuario> getByCondominiumId(Integer id)
    {
        return this.usuarioDao.getEntitiesByEntityColumn("condominio", id);
    }

    @Override
    public Usuario getByLogin(String login)
    {
        return this.usuarioDao.getEntityByEntityColumn("login", login);
    }

}
