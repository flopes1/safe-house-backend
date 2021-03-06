package com.poli.sh.model;
// Generated 23/06/2018 17:57:38 by Hibernate Tools 5.2.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * PedidoAutenticacao generated by hbm2java
 */
@Entity
@Table(name = "pedido_autenticacao", catalog = "safehouse")
public class PedidoAutenticacao implements java.io.Serializable
{

    private static final long serialVersionUID = -2795182476497447505L;

    private Integer id;
    @JsonBackReference(value = "con_ped")
    private Condominio condominio;
    @JsonBackReference(value = "user_ped")
    private Usuario usuario;
    private Date data;
    private Integer idUser;
    private Integer idCond;

    public PedidoAutenticacao()
    {
    }

    public PedidoAutenticacao(Condominio condominio, Usuario usuario, Date data, Integer idUser, Integer idCond)
    {
        this.condominio = condominio;
        this.usuario = usuario;
        this.data = data;
        this.idUser = idUser;
        this.idCond = idCond;
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

    @Column(name = "id_usuario", insertable = false, updatable = false)
    public Integer getIdUser()
    {
        return idUser;
    }

    public void setIdUser(Integer idUser)
    {
        this.idUser = idUser;
    }

    @Column(name = "id_condominio", insertable = false, updatable = false)
    public Integer getIdCond()
    {
        return idCond;
    }

    public void setIdCond(Integer idCond)
    {
        this.idCond = idCond;
    }

}
