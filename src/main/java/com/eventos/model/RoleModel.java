package com.eventos.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRole;

    private String nomeRole;

    public RoleModel() {}

    public RoleModel(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    public int getIdRole() { return idRole; }
    public void setIdRole(int idRole) { this.idRole = idRole; }

    public String getNomeRole() { return nomeRole; }
    public void setNomeRole(String nomeRole) { this.nomeRole = nomeRole; }

//    @Override
//    public String toString() {
//        return "Role{" +
//                "idRole=" + idRole +
//                ", nomeRole='" + nomeRole + '\'' +
//                '}';
//    }
}
