package com.eventos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eventos")
public class EventoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEvt;

    @Column(nullable = false, length = 200)
    private String nomeEvt;

    @Column(nullable = false, length = 1000)
    private String descEvt;

    // Colocar o seguinte comando na database evthj:
    // ALTER TABLE `eventos` CHANGE `data_evento` `data_evento` DATE;
    @Column(nullable = false)
    private Date dataEvt;

    @Column(nullable = false)
    private String qtdPessEvt;

    @Column(nullable = false)
    private String regiaoEvt;

    @Column(nullable = false, length = 250)
    private String endrcEvt;

    public EventoModel() {
        super();
    }

    public EventoModel(String nomeEvt, String descEvt, Date dataEvt, String qtdPessEvt, String regiaoEvt, String endrcEvt) {
        super();
        this.nomeEvt = nomeEvt;
        this.descEvt = descEvt;
        this.dataEvt = dataEvt;
        this.qtdPessEvt = qtdPessEvt;
        this.regiaoEvt = regiaoEvt;
        this.endrcEvt = endrcEvt;
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
}
