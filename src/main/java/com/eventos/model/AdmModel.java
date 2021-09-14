package com.eventos.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "adms")
public class AdmModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int idAdm;

    @Column(nullable = false, length = 32, unique = true)
    private String nomeAdm;

    @Column(nullable = false, unique = true)
    private String emailAdm;

    @Column(nullable = false)
    private String senhaAdm;

    @Column(nullable = false, length = 1000)
    private String descAdm;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (
            name = "relacao_adms_roles",
            joinColumns = @JoinColumn (
                    name = "idDoAdm", referencedColumnName = "idAdm"),
            inverseJoinColumns = @JoinColumn (
                    name = "idDaRole", referencedColumnName = "idRole")
    )
    private Collection<RoleModel> role;

    public AdmModel() {
//        super();
    }

    public AdmModel(String nomeAdm, String emailAdm, String senhaAdm, String descAdm) {
//        super();
        this.nomeAdm = nomeAdm;
        this.emailAdm = emailAdm;
        this.senhaAdm = senhaAdm;
        this.descAdm = descAdm;
    }

    public AdmModel(String nomeAdm, String emailAdm, String senhaAdm, String descAdm, Collection<RoleModel> role) {
        this.nomeAdm = nomeAdm;
        this.emailAdm = emailAdm;
        this.senhaAdm = senhaAdm;
        this.descAdm = descAdm;
        this.role = role;
    }

    public int getIdAdm() { return idAdm; }
    public void setIdAdm(int idAdm) { this.idAdm = idAdm; }

    public String getNomeAdm() { return nomeAdm; }
    public void setNomeAdm(String nomeAdm) { this.nomeAdm = nomeAdm; }

    public String getEmailAdm() { return emailAdm; }
    public void setEmailAdm(String emailAdm) { this.emailAdm = emailAdm; }

    public String getSenhaAdm() { return senhaAdm; }
    public void setSenhaAdm(String senhaAdm) { this.senhaAdm = senhaAdm; }

    public String getDescAdm() { return descAdm; }
    public void setDescAdm(String descAdm) { this.descAdm = descAdm; }

    public Collection<RoleModel> getRole() { return role; }
    public void setRole(Collection<RoleModel> role) { this.role = role; }
}
