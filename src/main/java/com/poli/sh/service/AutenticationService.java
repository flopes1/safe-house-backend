package com.poli.sh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poli.sh.dao.def.IAutenticationDao;
import com.poli.sh.model.Condominio;
import com.poli.sh.model.PedidoAutenticacao;
import com.poli.sh.model.Usuario;
import com.poli.sh.service.def.IAutenticationService;
import com.poli.sh.service.def.ICondominiumService;
import com.poli.sh.service.def.IUserService;

/* 
* @author Filipe Mendes
*
*/

@Service
@Transactional
public class AutenticationService implements IAutenticationService
{

    // private static final Logger log = LoggerFactory.getLogger(AutenticationService.class);

    @Autowired
    private IAutenticationDao autenticationDao;

    @Autowired
    private ICondominiumService condominioService;

    @Autowired
    private IUserService userService;

    @Override
    public void autenticationRequest(PedidoAutenticacao pedidoAutenticacao)
    {
        pedidoAutenticacao.setData(new Date());
        this.autenticationDao.add(pedidoAutenticacao);
    }

    @Override
    public void approveAutenticationRequest(Integer id)
    {
        PedidoAutenticacao ped = this.getById(id);
        this.condominioService.removeAutentication(ped.getIdCond(), id);
        this.userService.removeAutentication(ped.getIdUser(), id);

        Condominio c = this.condominioService.getById(ped.getIdCond());
        this.condominioService.update(c);
        Usuario u = this.userService.getById(ped.getIdUser());
        this.userService.update(u);
    }

    @Override
    public PedidoAutenticacao getById(Integer id)
    {
        return this.autenticationDao.getById(id);
    }

    @Override
    public List<PedidoAutenticacao> getRequestsByCondominium(Integer condominiumId)
    {
        List<PedidoAutenticacao> pedidos = this.autenticationDao.getByCondominiumId(condominiumId);
        List<PedidoAutenticacao> pedidosByCond = new ArrayList<PedidoAutenticacao>();

        for (PedidoAutenticacao p : pedidos)
        {
            if (p.getIdCond() == condominiumId)
            {
                pedidosByCond.add(p);
            }
        }
        return pedidosByCond;
    }

}
