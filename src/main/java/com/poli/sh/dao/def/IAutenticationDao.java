package com.poli.sh.dao.def;

import java.util.List;

import com.poli.sh.model.PedidoAutenticacao;

public interface IAutenticationDao
{

    void add(PedidoAutenticacao pedidoAutenticacao);

    void remove(Integer id);

    PedidoAutenticacao getById(Integer id);

    List<PedidoAutenticacao> getByCondominiumId(Integer id);

}
