package com.poli.sh.model;
// Generated 23/06/2018 17:57:38 by Hibernate Tools 5.2.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Veiculo generated by hbm2java
 */
@Entity
@Table(name = "veiculo", catalog = "safehouse")
public class Veiculo implements java.io.Serializable
{

    private static final long serialVersionUID = 8821177919718832213L;

    private Integer id;
    @JsonBackReference(value = "user_vei")
    private Usuario usuario;
    private String modelo;
    private String cor;
    private String placa;

    public Veiculo()
    {
    }

    public Veiculo(Usuario usuario, String modelo, String cor, String placa)
    {
        this.usuario = usuario;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
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
    @JoinColumn(name = "id_usuario", nullable = false)
    public Usuario getUsuario()
    {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    @Column(name = "modelo", nullable = false)
    public String getModelo()
    {
        return this.modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    @Column(name = "cor", nullable = false)
    public String getCor()
    {
        return this.cor;
    }

    public void setCor(String cor)
    {
        this.cor = cor;
    }

    @Column(name = "placa", nullable = false)
    public String getPlaca()
    {
        return this.placa;
    }

    public void setPlaca(String placa)
    {
        this.placa = placa;
    }

}
