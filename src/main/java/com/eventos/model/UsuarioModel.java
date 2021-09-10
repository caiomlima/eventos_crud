package com.eventos.model;

import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsr;

    @Column(nullable = false, length = 32)
    private String nomeUsr;

    @Column(nullable = false)
    private String emailUsr;

    @Column(nullable = false)
    private String senhaUsr;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (
            name = "relacao_users_roles",
            joinColumns = @JoinColumn (
                    name = "idDoUser", referencedColumnName = "idUsr"),
            inverseJoinColumns = @JoinColumn (
                    name = "idDaRole", referencedColumnName = "idRole")
    )
    private Collection<RoleModel> role;

    public UsuarioModel() {
//        super();
    }

    public UsuarioModel(String nomeUsr, String emailUsr, String senhaUsr) {
//        super();
        this.nomeUsr = nomeUsr;
        this.emailUsr = emailUsr;
        this.senhaUsr = senhaUsr;
    }

    public UsuarioModel(String nomeUsr, String emailUsr, String senhaUsr, Collection<RoleModel> roles) {
        this.nomeUsr = nomeUsr;
        this.emailUsr = emailUsr;
        this.senhaUsr = senhaUsr;
        this.role = roles;
    }

    public int getIdUsr() { return idUsr; }
    public void setIdUsr(int idUsr) { this.idUsr = idUsr; }

    public String getNomeUsr() { return nomeUsr; }
    public void setNomeUsr(String nomeUsr) { this.nomeUsr = nomeUsr; }

    public String getEmailUsr() { return emailUsr; }
    public void setEmailUsr(String emailUsr) { this.emailUsr = emailUsr; }

    public String getSenhaUsr() { return senhaUsr; }
    public void setSenhaUsr(String senhaUsr) { this.senhaUsr = senhaUsr; }

    public Collection<RoleModel> getRoles() { return role; }
    public void setRoles(Collection<RoleModel> roles) { this.role = roles; }

//    @Override
//    public String toString() {
//        return "Usuario{" +
//                "id=" + idUsr +
//                ", nomeUsr='" + nomeUsr + '\'' +
//                ", emailUsr='" + emailUsr + '\'' +
//                ", senhaUsr='" + "*********" + '\'' +
//                ", role=" + role +
//                '}';
//    }
}
