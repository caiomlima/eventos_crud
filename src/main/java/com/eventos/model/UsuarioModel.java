package com.eventos.model;

import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsr;

    @NotNull @NotEmpty @Size(min = 1, max = 100, message = "Digite o nome de sua empresa no tamanho maximo de 100 caracteres")
    private String nomeUsr;

    @NotNull @NotEmpty @Column(unique = true)
    private String emailUsr;

    @NotNull @NotEmpty @Size(min = 8, max = 64, message = "Digite uma senha que contenha entre 8 e 64 caracteres")
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
        super();
        this.nomeUsr = nomeUsr;
        this.emailUsr = emailUsr;
        this.senhaUsr = senhaUsr;
    }

    public UsuarioModel(String nomeUsr, String emailUsr, String senhaUsr, Collection<RoleModel> role) {
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
        return "Usuario{" +
                "idUsr=" + idUsr +
                ", nomeUsr='" + nomeUsr + '\'' +
                ", emailUsr='" + emailUsr + '\'' +
                ", senhaUsr='" + "*********" + '\'' +
                ", role=" + role +
                '}';
    }
}
