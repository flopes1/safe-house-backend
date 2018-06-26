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

import com.poli.sh.model.PedidoAutenticacao;
import com.poli.sh.service.def.IAutenticationService;

/**
 * 
 * @author Filipe Mendes
 *
 */

@RestController
@RequestMapping("/aut")
public class AutenticationController
{

    private static final Logger log = LoggerFactory.getLogger(AutenticationController.class);

    @Autowired
    private IAutenticationService autenticationService;

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public ResponseEntity<Void> requestAutentication(@RequestBody PedidoAutenticacao pedidoAutenticacao)
    {
        log.info("POST /request called");

        ResponseEntity<Void> response = null;

        if (pedidoAutenticacao != null)
        {
            try
            {
                this.autenticationService.autenticationRequest(pedidoAutenticacao);
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

    @RequestMapping(value = "approve/{id}", method = RequestMethod.GET)
    public ResponseEntity<Void> approveRequest(@PathVariable Integer id)
    {
        log.info("GEt /approve/{} called", id);

        ResponseEntity<Void> response = null;

        if (id != null && id.longValue() > 0)
        {
            try
            {
                this.autenticationService.approveAutenticationRequest(id);
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
    public ResponseEntity<PedidoAutenticacao> getById(@PathVariable Integer id)
    {
        log.info("GET /aut/{} called", id);

        ResponseEntity<PedidoAutenticacao> response = null;

        if (id != null && id.longValue() > 0)
        {
            try
            {
                PedidoAutenticacao auth = this.autenticationService.getById(id);

                if (auth == null)
                {
                    response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                else
                {
                    response = ResponseEntity.status(HttpStatus.OK).body(auth);
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

    @RequestMapping(value = "cond/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PedidoAutenticacao>> getByCondominiumId(@PathVariable Integer id)
    {
        log.info("GET /cond/{} called", id);

        ResponseEntity<List<PedidoAutenticacao>> response = null;

        if (id != null && id.longValue() > 0)
        {
            try
            {
                List<PedidoAutenticacao> auths = this.autenticationService.getRequestsByCondominium(id);

                if (auths == null)
                {
                    response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                else
                {
                    response = ResponseEntity.status(HttpStatus.OK).body(auths);
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
