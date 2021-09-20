package com.eventos.model;

import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "orgs")
public class OrgModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(unique = true)
    private int idOrg;

    @NotNull @NotEmpty @Size(min = 1, max = 100, message = "Digite o nome de sua empresa no tamanho maximo de 100 caracteres")
    private String nomeOrg;

    @NotNull @NotEmpty @Column(unique = true)
    private String emailOrg;

    @NotNull @NotEmpty @Size(min = 8, max = 64, message = "Digite uma senha que contenha entre 8 e 64 caracteres")
    private String senhaOrg;

    @NotNull @NotEmpty @Size(min= 10, max = 1000, message = "Digite a descrição de sua empresa entre 10 e 1000 caracteres")
    private String descOrg;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (
            name = "relacao_orgs_roles", joinColumns = @JoinColumn (name = "idDoOrg", referencedColumnName = "idOrg"),
            inverseJoinColumns = @JoinColumn (name = "idDaRole", referencedColumnName = "idRole")
    )
    private Collection<RoleModel> role;

    public OrgModel() {
//        super();
    }

    public OrgModel(String nomeOrg, String emailOrg, String senhaOrg, String descOrg) {
        super();
        this.nomeOrg = nomeOrg;
        this.emailOrg = emailOrg;
        this.senhaOrg = senhaOrg;
        this.descOrg = descOrg;
    }

    public OrgModel(String nomeOrg, String emailOrg, String senhaOrg, String descOrg, Collection<RoleModel> role) {
        this.nomeOrg = nomeOrg;
        this.emailOrg = emailOrg;
        this.senhaOrg = senhaOrg;
        this.descOrg = descOrg;
        this.role = role;
    }

    public int getIdOrg() { return idOrg; }
    public void setIdOrg(int idOrg) { this.idOrg = idOrg; }

    public String getNomeOrg() { return nomeOrg; }
    public void setNomeOrg(String nomeOrg) { this.nomeOrg = nomeOrg; }

    public String getEmailOrg() { return emailOrg; }
    public void setEmailOrg(String emailOrg) { this.emailOrg = emailOrg; }

    public String getSenhaOrg() { return senhaOrg; }
    public void setSenhaOrg(String senhaOrg) { this.senhaOrg = senhaOrg; }

    public String getDescOrg() { return descOrg; }
    public void setDescOrg(String descOrg) { this.descOrg = descOrg; }

    public Collection<RoleModel> getRole() { return role; }
    public void setRole(Collection<RoleModel> role) { this.role = role; }

    @Override
    public String toString() {
        return "Org{" +
                "idOrg=" + idOrg +
                ", nomeOrg='" + nomeOrg + '\'' +
                ", emailOrg='" + emailOrg + '\'' +
                ", senhaOrg='" + "*********" + '\'' +
                ", role=" + role +
                '}';
    }
}
