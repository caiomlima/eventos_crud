package com.eventos.model;

import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class UserModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(unique = true)
    private int idUsr;

    @NotNull @NotEmpty @Size(min = 1, max = 100, message = "Digite o seu nome")
    private String nomeUsr;

    @NotNull @NotEmpty @Column(unique = true)
    private String emailUsr;

    @NotNull @NotEmpty @Size(min = 8, max = 64, message = "Digite uma senha que contenha entre 8 e 64 caracteres")
    private String senhaUsr;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (
            name = "rlt_users_roles", joinColumns = @JoinColumn (name = "idUser", referencedColumnName = "idUsr"),
            inverseJoinColumns = @JoinColumn (name = "roleId", referencedColumnName = "idRole")
    )
    private Collection<RoleModel> role;

    public UserModel() {
//        super();
    }

    public UserModel(String nomeUsr, String emailUsr, String senhaUsr, String sobrenomeUsr) {
        super();
        this.nomeUsr = nomeUsr;
        this.emailUsr = emailUsr;
        this.senhaUsr = senhaUsr;
    }

    public UserModel(String nomeUsr, String emailUsr, String senhaUsr, Collection<RoleModel> role) {
        this.nomeUsr = nomeUsr;
        this.emailUsr = emailUsr;
        this.senhaUsr = senhaUsr;
        this.role = role;
    }

    public int getIdUsr() { return idUsr; }
    public void setIdUsr(int idUsr) { this.idUsr = idUsr; }

    public String getNomeUsr() { return nomeUsr; }
    public void setNomeUsr(String nomeUsr) { this.nomeUsr = nomeUsr; }

    public String getEmailUsr() { return emailUsr; }
    public void setEmailUsr(String emailUsr) { this.emailUsr = emailUsr; }

    public String getSenhaUsr() { return senhaUsr; }
    public void setSenhaUsr(String senhaUsr) { this.senhaUsr = senhaUsr; }

    public Collection<RoleModel> getRole() { return role; }
    public void setRole(Collection<RoleModel> role) { this.role = role; }

    @Override
    public String toString() {
        return "Usr{" +
                "idUsr=" + idUsr +
                ", nomeUsr='" + nomeUsr + '\'' +
                ", emailUsr='" + emailUsr + '\'' +
                ", senhaUsr='" + "*********" + '\'' +
                ", role=" + role +
                '}';
    }
}
