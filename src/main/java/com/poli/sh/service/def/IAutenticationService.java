package com.poli.sh.service.def;

import java.util.List;

import com.poli.sh.model.PedidoAutenticacao;

public interface IAutenticationService
{

    void autenticationRequest(PedidoAutenticacao pedidoAutenticacao);

    void approveAutenticationRequest(Integer id);

    PedidoAutenticacao getById(Integer id);

    List<PedidoAutenticacao> getRequestsByCondominium(Integer condominiumId);
    
}
