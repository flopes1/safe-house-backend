package com.poli.sh.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poli.sh.model.Usuario;
import com.poli.sh.service.def.IUserService;

/**
 * 
 * @author Filipe Mendes
 *
 */

@RestController
@RequestMapping("/user")
public class UserController
{

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody Usuario usuario)
    {
        log.info("POST /user called");

        ResponseEntity<Void> response = null;

        if (usuario != null)
        {
            try
            {
                this.userService.add(usuario);
                response = new ResponseEntity<Void>(HttpStatus.OK);

            }
            catch (Exception e)
            {
                response = new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
                log.error("Error executing request {}. ", e.getMessage());
            }

        }
        else
        {
            response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id)
    {
        log.info("DELETE /user called");

        ResponseEntity<Void> response = null;

        if (id != null && id.longValue() > 0)
        {
            try
            {
                this.userService.remove(id);
                response = new ResponseEntity<Void>(HttpStatus.OK);

            }
            catch (Exception e)
            {
                response = new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
                log.error("Error executing request {}. ", e.getMessage());
            }

        }
        else
        {
            response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> getById(@PathVariable Integer id)
    {
        log.info("GET /user {} called", id);

        ResponseEntity<Usuario> response = null;

        if (id != null && id.longValue() > 0)
        {
            try
            {
                Usuario user = this.userService.getById(id);

                if (user == null)
                {
                    response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                else
                {
                    response = ResponseEntity.status(HttpStatus.OK).body(user);
                }

            }
            catch (Exception e)
            {
                response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                log.error("Error executing request {}. ", e.getMessage());
            }

        }
        else
        {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Void> update(@RequestBody Usuario usuario)
    {
        log.info("POST update /user called");

        ResponseEntity<Void> response = null;

        if (usuario != null)
        {
            try
            {
                this.userService.update(usuario);
                response = new ResponseEntity<Void>(HttpStatus.OK);

            }
            catch (Exception e)
            {
                response = new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
                log.error("Error executing request {}. ", e.getMessage());
            }

        }
        else
        {
            response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    @RequestMapping(value = "/condId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> getByCondominium(@PathVariable Integer id)
    {
        log.info("GET /condId called");

        ResponseEntity<List<Usuario>> response = null;

        if (id != null && id.longValue() > 0)
        {
            try
            {
                List<Usuario> users = this.userService.getByCondominiumId(id);

                if (users == null)
                {
                    response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                else
                {
                    response = ResponseEntity.status(HttpStatus.OK).body(users);
                }

            }
            catch (Exception e)
            {
                response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                log.error("Error executing request {}. ", e.getMessage());
            }

        }
        else
        {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<Usuario> login(@RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password)
    {
        log.info("POST /login {} called", login);

        ResponseEntity<Usuario> response = null;

        if (login != null && !login.isEmpty() && password != null && !password.isEmpty())
        {
            try
            {
                Usuario logged = this.userService.login(login, password);

                if (logged != null)
                {
                    response = ResponseEntity.ok().body(logged);
                }
                else
                {
                    response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
                }

            }
            catch (Exception e)
            {
                response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                log.error("Error executing request {}. ", e.getMessage());
            }

        }
        else
        {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return response;
    }

}
