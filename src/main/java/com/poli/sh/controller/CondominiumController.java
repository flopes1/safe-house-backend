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
import org.springframework.web.bind.annotation.RestController;

import com.poli.sh.model.Condominio;
import com.poli.sh.service.def.ICondominiumService;

/**
 * 
 * @author Filipe Mendes
 *
 */

@RestController
@RequestMapping("/cond")
public class CondominiumController
{

    private static final Logger log = LoggerFactory.getLogger(CondominiumController.class);

    @Autowired
    private ICondominiumService condominiumService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody Condominio condominium)
    {
        log.info("POST /user called");

        ResponseEntity<Void> response = null;

        if (condominium != null)
        {
            try
            {
                this.condominiumService.add(condominium);
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
                this.condominiumService.remove(id);
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
    public ResponseEntity<Condominio> getById(@PathVariable Integer id)
    {
        log.info("GET /user {} called", id);

        ResponseEntity<Condominio> response = null;

        if (id != null && id.longValue() > 0)
        {
            try
            {
                Condominio cond = this.condominiumService.getById(id);

                if (cond == null)
                {
                    response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                else
                {
                    response = ResponseEntity.status(HttpStatus.OK).body(cond);
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
    public ResponseEntity<Void> update(@RequestBody Condominio cond)
    {
        log.info("POST update /user called");

        ResponseEntity<Void> response = null;

        if (cond != null)
        {
            try
            {
                this.condominiumService.update(cond);
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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Condominio>> getAll()
    {
        log.info("GET /all called");

        ResponseEntity<List<Condominio>> response = null;

        try
        {
            List<Condominio> conds = this.condominiumService.getAll();

            if (conds == null)
            {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            else
            {
                response = ResponseEntity.status(HttpStatus.OK).body(conds);
            }

        }
        catch (Exception e)
        {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            log.error("Error executing request {}. ", e.getMessage());
        }

        return response;
    }

}
