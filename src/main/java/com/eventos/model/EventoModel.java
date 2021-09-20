package com.eventos.model;

import org.hibernate.type.DateType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "eventos")
public class EventoModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEvt;

    @NotEmpty @Size(min = 5, max = 150, message = "Digite um nome que tenha entre 5 e 150 caracteres") @Column(nullable = false)
    private String nomeEvt;

    @NotEmpty @Size(min = 10, max = 1000, message = "Digite uma descrição para o evento, que tenha entre 10 e 1000 caracteres") @Column(nullable = false)
    private String descEvt;

    // Colocar o seguinte comando na database evthj:
    // ALTER TABLE `eventos` CHANGE `data_evento` `data_evento` DATE;
    @Column(nullable = false)
    private Date dataEvt;

    @NotEmpty @Column(nullable = false)
    private String qtdPessEvt;

    @NotEmpty @Column(nullable = false)
    private String regiaoEvt;

    @NotEmpty @Size(min = 10, max = 250, message = "Digite o endereço do evento, que tenha entre 10 e 250 caracteres") @Column(nullable = false)
    private String endrcEvt;

    @Column(nullable = false)
    private String orgEvt;

    public EventoModel() {
        super();
    }

    public EventoModel(String nomeEvt, String descEvt, Date dataEvt, String qtdPessEvt, String regiaoEvt, String endrcEvt, String orgEvt) {
        super();
        this.nomeEvt = nomeEvt;
        this.descEvt = descEvt;
        this.dataEvt = dataEvt;
        this.qtdPessEvt = qtdPessEvt;
        this.regiaoEvt = regiaoEvt;
        this.endrcEvt = endrcEvt;
        this.orgEvt = orgEvt;
    }

    public int getIdEvt() { return idEvt; }
    public void setIdEvt(int idEvt) { this.idEvt = idEvt; }

    public String getNomeEvt() { return nomeEvt; }
    public void setNomeEvt(String nomeEvt) { this.nomeEvt = nomeEvt; }

    public String getDescEvt() { return descEvt; }
    public void setDescEvt(String descEvt) { this.descEvt = descEvt; }

    public Date getDataEvt() { return dataEvt; }
    public void setDataEvt(Date dataEvt) { this.dataEvt = dataEvt; }

    public String getQtdPessEvt() { return qtdPessEvt; }
    public void setQtdPessEvt(String qtdPessEvt) { this.qtdPessEvt = qtdPessEvt; }

    public String getRegiaoEvt() { return regiaoEvt; }
    public void setRegiaoEvt(String regiaoEvt) { this.regiaoEvt = regiaoEvt; }

    public String getEndrcEvt() { return endrcEvt; }
    public void setEndrcEvt(String endrcEvt) { this.endrcEvt = endrcEvt; }

    public String getOrgEvt() { return orgEvt; }
    public void setOrgEvt(String orgEvt) { this.orgEvt = orgEvt; }
}
