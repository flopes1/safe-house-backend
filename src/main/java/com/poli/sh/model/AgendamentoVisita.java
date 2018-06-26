package com.poli.sh.model;
// Generated 23/06/2018 17:57:38 by Hibernate Tools 5.2.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * AgendamentoVisita generated by hbm2java
 */
@Entity
@Table(name = "agendamento_visita", catalog = "safehouse")
public class AgendamentoVisita implements java.io.Serializable
{

    private static final long serialVersionUID = 5181763424932689680L;

    private Integer id;
    @JsonBackReference(value = "con_agen")
    private Condominio condominio;
    @JsonBackReference(value = "user_agen")
    private Usuario usuario;
    private Integer idUsuario;
    private Date data;
    private String descricao;
    @JsonManagedReference(value = "agen_visit")
    private List<Visitante> visitantes = new ArrayList<Visitante>(0);

    public AgendamentoVisita()
    {
    }

    public AgendamentoVisita(Condominio condominio, Usuario usuario, Date data)
    {
        this.condominio = condominio;
        this.usuario = usuario;
        this.data = data;
    }

    public AgendamentoVisita(Condominio condominio, Usuario usuario, Date data, String descricao,
            List<Visitante> visitantes)
    {
        this.condominio = condominio;
        this.usuario = usuario;
        this.data = data;
        this.descricao = descricao;
        this.visitantes = visitantes;
    }

    public AgendamentoVisita(Condominio condominio, Usuario usuario, Date data, String descricao,
            List<Visitante> visitantes, Integer idUsuario)
    {
        this(condominio, usuario, data, descricao, visitantes);
        this.idUsuario = idUsuario;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_condominio", nullable = false)
    public Condominio getCondominio()
    {
        return this.condominio;
    }

    public void setCondominio(Condominio condominio)
    {
        this.condominio = condominio;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", nullable = false)
    public Usuario getUsuario()
    {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false, length = 19)
    public Date getData()
    {
        return this.data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    @Column(name = "descricao")
    public String getDescricao()
    {
        return this.descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "agendamentoVisita", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Visitante> getVisitantes()
    {
        return this.visitantes;
    }

    public void setVisitantes(List<Visitante> visitantes)
    {
        this.visitantes = visitantes;
    }

    @Column(name = "id_usuario", insertable = false, updatable = false)
    public Integer getIdUsuario()
    {
        return this.idUsuario;
    }

    public void setIdUsuario(Integer idUsuario)
    {
        this.idUsuario = idUsuario;
    }

}