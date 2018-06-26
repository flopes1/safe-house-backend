package com.poli.sh.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poli.sh.dao.def.IUserDao;
import com.poli.sh.model.PedidoAutenticacao;
import com.poli.sh.model.Usuario;
import com.poli.sh.service.def.ICondominiumService;
import com.poli.sh.service.def.IUserService;

/* 
* @author Filipe Mendes
*
*/

@Service
@Transactional
public class UserService implements IUserService
{

    // private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserDao userDao;

    @Autowired
    private ICondominiumService condService;

    @Override
    public void add(Usuario usuario)
    {
        this.userDao.add(usuario);
    }

    @Override
    public void remove(Integer id)
    {
        Usuario usuario = this.getById(id);
        this.condService.removeUser(usuario.getCondominioId(), id);
    }

    @Override
    public Usuario getById(Integer id)
    {
        return this.userDao.getById(id);
    }

    @Override
    public Usuario update(Usuario usuario)
    {
        return this.userDao.update(usuario);
    }

    @Override
    public List<Usuario> getByCondominiumId(Integer id)
    {
        return this.userDao.getByCondominiumId(id);
    }

    @Override
    public Usuario login(String login, String password)
    {
        Usuario user = this.userDao.getByLogin(login);
        Usuario logged = null;

        if (user != null && user.getSenha().equals(password))
        {
            logged = user;
        }
        return logged;
    }

    @Override
    public void removeAutentication(Integer idUser, Integer id)
    {
        Usuario u = this.getById(idUser);
        Iterator<PedidoAutenticacao> iterator = u.getPedidoAutenticacaos().iterator();
        while (iterator.hasNext())
        {
            if (id == iterator.next().getId())
            {
                iterator.remove();
                break;
            }
        }
    }

}
