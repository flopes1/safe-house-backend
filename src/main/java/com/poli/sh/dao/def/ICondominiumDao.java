package com.poli.sh.dao.def;

import java.util.List;

import com.poli.sh.model.Condominio;

public interface ICondominiumDao
{

    void add(Condominio condominio);

    Condominio getById(Integer id);

    Condominio update(Condominio condominio);

    void remove(Integer id);

    List<Condominio> getAll();

}
