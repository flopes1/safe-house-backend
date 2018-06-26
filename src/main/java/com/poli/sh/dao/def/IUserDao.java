package com.poli.sh.dao.def;

import java.util.List;

import com.poli.sh.model.Usuario;

public interface IUserDao
{

    void add(Usuario usuario);

    void remove(Integer id);

    Usuario getById(Integer id);

    Usuario update(Usuario usuario);

    List<Usuario> getByCondominiumId(Integer id);
    
    Usuario getByLogin(String login);

}
