package com.poli.sh.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poli.sh.dao.def.ICondominiumDao;
import com.poli.sh.model.Condominio;
import com.poli.sh.model.PedidoAutenticacao;
import com.poli.sh.model.Usuario;
import com.poli.sh.service.def.ICondominiumService;

/**
 * 
 * @author Filipe Mendes
 *
 */

@Service
@Transactional
public class CondominioService implements ICondominiumService
{

    // private static final Logger log = LoggerFactory.getLogger(CondominioService.class);

    @Autowired
    private ICondominiumDao condominioDao;

    @Override
    public void add(Condominio condominio)
    {
        this.condominioDao.add(condominio);
    }

    @Override
    public Condominio getById(Integer id)
    {
        return this.condominioDao.getById(id);
    }

    @Override
    public Condominio update(Condominio condominio)
    {
        return this.condominioDao.update(condominio);
    }

    @Override
    public void remove(Integer id)
    {
        this.condominioDao.remove(id);
    }

    @Override
    public List<Condominio> getAll()
    {
        return this.condominioDao.getAll();
    }

    @Override
    public void removeUser(Integer condId, Integer userId)
    {
        Condominio c = this.getById(condId);
        Iterator<Usuario> iterator = c.getUsuarios().iterator();
        while (iterator.hasNext())
        {
            if (userId == iterator.next().getId())
            {
                iterator.remove();
                break;
            }
        }
        this.update(c);
    }

    @Override
    public void removeAutentication(Integer condId, Integer authId)
    {
        Condominio c = this.getById(condId);
        Iterator<PedidoAutenticacao> iterator = c.getPedidoAutenticacaos().iterator();
        while (iterator.hasNext())
        {
            if (authId == iterator.next().getId())
            {
                iterator.remove();
                break;
            }
        }
    }

}
