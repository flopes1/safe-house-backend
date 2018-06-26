package com.poli.sh.model;
// Generated 23/06/2018 17:57:38 by Hibernate Tools 5.2.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "safehouse")
public class Usuario implements Serializable
{

    private static final long serialVersionUID = 9019957192828007306L;

    private Integer id;
    @JsonBackReference(value = "con_user")
    private Condominio condominio;
    private Integer condominioId;
    private EnumTipoUsuario enumTipoUsuario;
    private String nome;
    private String login;
    private String senha;
    private Boolean ativo;
    private String email;
    @JsonManagedReference(value = "user_vei")
    private List<Veiculo> veiculos = new ArrayList<Veiculo>(0);
    @JsonManagedReference(value = "user_agen")
    private List<AgendamentoVisita> agendamentoVisitas = new ArrayList<AgendamentoVisita>(0);
    @JsonManagedReference(value = "user_ped")
    private List<PedidoAutenticacao> pedidoAutenticacaos = new ArrayList<PedidoAutenticacao>(0);

    public Usuario()
    {
    }

    public Usuario(Condominio condominio, EnumTipoUsuario enumTipoUsuario, String nome, String login, String senha)
    {
        this.condominio = condominio;
        this.enumTipoUsuario = enumTipoUsuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(Condominio condominio, EnumTipoUsuario enumTipoUsuario, String nome, String login, String senha,
            Boolean ativo, String email, List<Veiculo> veiculos, List<AgendamentoVisita> agendamentoVisitas,
            List<PedidoAutenticacao> pedidoAutenticacaos)
    {
        this.condominio = condominio;
        this.enumTipoUsuario = enumTipoUsuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        this.email = email;
        this.veiculos = veiculos;
        this.agendamentoVisitas = agendamentoVisitas;
        this.pedidoAutenticacaos = pedidoAutenticacaos;
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
    @JoinColumn(name = "id_enum_tipo_usuario", nullable = false)
    public EnumTipoUsuario getEnumTipoUsuario()
    {
        return this.enumTipoUsuario;
    }

    public void setEnumTipoUsuario(EnumTipoUsuario enumTipoUsuario)
    {
        this.enumTipoUsuario = enumTipoUsuario;
    }

    @Column(name = "nome", nullable = false)
    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    @Column(name = "login", nullable = false)
    public String getLogin()
    {
        return this.login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    @Column(name = "senha", nullable = false)
    public String getSenha()
    {
        return this.senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    @Column(name = "ativo")
    public Boolean getAtivo()
    {
        return this.ativo;
    }

    public void setAtivo(Boolean ativo)
    {
        this.ativo = ativo;
    }

    @Column(name = "email")
    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Veiculo> getVeiculos()
    {
        return this.veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos)
    {
        this.veiculos = veiculos;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<AgendamentoVisita> getAgendamentoVisitas()
    {
        return this.agendamentoVisitas;
    }

    public void setAgendamentoVisitas(List<AgendamentoVisita> agendamentoVisitas)
    {
        this.agendamentoVisitas = agendamentoVisitas;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<PedidoAutenticacao> getPedidoAutenticacaos()
    {
        return this.pedidoAutenticacaos;
    }

    public void setPedidoAutenticacaos(List<PedidoAutenticacao> pedidoAutenticacaos)
    {
        this.pedidoAutenticacaos = pedidoAutenticacaos;
    }

    @Column(name = "id_condominio", insertable = false, updatable = false)
    public Integer getCondominioId()
    {
        return condominioId;
    }

    public void setCondominioId(Integer condominioId)
    {
        this.condominioId = condominioId;
    }

}
