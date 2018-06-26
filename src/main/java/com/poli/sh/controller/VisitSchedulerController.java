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

import com.poli.sh.model.AgendamentoVisita;
import com.poli.sh.service.def.IVisitSchedulerService;

/**
 * 
 * @author Filipe Mendes
 *
 */

@RestController
@RequestMapping("/visit")
public class VisitSchedulerController
{

    private static final Logger log = LoggerFactory.getLogger(VisitSchedulerController.class);

    @Autowired
    private IVisitSchedulerService visitSchedulerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody AgendamentoVisita agendamentoVisita)
    {
        log.info("POST /visit/add called");

        ResponseEntity<Void> response = null;

        if (agendamentoVisita != null)
        {
            try
            {
                this.visitSchedulerService.add(agendamentoVisita);
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
        log.info("DELETE /visit called");

        ResponseEntity<Void> response = null;

        if (id != null && id.longValue() > 0)
        {
            try
            {
                this.visitSchedulerService.remove(id);
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

    @RequestMapping(value = "cond/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<AgendamentoVisita>> getByCondId(@PathVariable Integer id)
    {
        log.info("GET /user {} called", id);

        ResponseEntity<List<AgendamentoVisita>> response = null;

        if (id != null && id.longValue() > 0)
        {
            try
            {
                List<AgendamentoVisita> agendamentos = this.visitSchedulerService.getByCondominiumId(id);

                if (agendamentos == null)
                {
                    response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                else
                {
                    response = ResponseEntity.status(HttpStatus.OK).body(agendamentos);
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

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<AgendamentoVisita>> getByUserId(@PathVariable Integer id)
    {
        log.info("GET /user {} called", id);

        ResponseEntity<List<AgendamentoVisita>> response = null;

        if (id != null && id.longValue() > 0)
        {
            try
            {
                List<AgendamentoVisita> agendamentos = this.visitSchedulerService.getByUserId(id);

                if (agendamentos == null)
                {
                    response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                else
                {
                    response = ResponseEntity.status(HttpStatus.OK).body(agendamentos);
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
    public ResponseEntity<Void> update(@RequestBody AgendamentoVisita agendamentoVisita)
    {
        log.info("POST update /user called");

        ResponseEntity<Void> response = null;

        if (agendamentoVisita != null)
        {
            try
            {
                this.visitSchedulerService.update(agendamentoVisita);
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

}
