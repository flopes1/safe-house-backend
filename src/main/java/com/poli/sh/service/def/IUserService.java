package com.poli.sh.service.def;

import java.util.List;

import com.poli.sh.model.Usuario;

public interface IUserService
{

    void add(Usuario usuario);

    void remove(Integer id);

    Usuario getById(Integer id);

    Usuario update(Usuario usuario);

    List<Usuario> getByCondominiumId(Integer id);

    Usuario login(String login, String password);

    void removeAutentication(Integer idUser, Integer id);

}
