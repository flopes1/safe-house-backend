package com.poli.sh.model;
// Generated 23/06/2018 17:57:38 by Hibernate Tools 5.2.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EnumTipoUsuario generated by hbm2java
 */
@Entity
@Table(name = "enum_tipo_usuario", catalog = "safehouse")
public class EnumTipoUsuario implements java.io.Serializable
{

    private static final long serialVersionUID = -6453450026496911301L;

    private Integer id;
    private String tipo;

    public EnumTipoUsuario()
    {
    }

    public EnumTipoUsuario(String tipo)
    {
        this.tipo = tipo;
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

    @Column(name = "tipo", nullable = false)
    public String getTipo()
    {
        return this.tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

}
