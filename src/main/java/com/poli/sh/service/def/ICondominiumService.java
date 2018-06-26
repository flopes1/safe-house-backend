package com.poli.sh.service.def;

import java.util.List;

import com.poli.sh.model.Condominio;

public interface ICondominiumService
{

    void add(Condominio condominio);

    Condominio getById(Integer id);

    Condominio update(Condominio condominio);

    void remove(Integer id);

    List<Condominio> getAll();

    void removeUser(Integer condId, Integer userId);

    void removeAutentication(Integer id, Integer id2);
    
}
