package com.eventos.model;

import org.hibernate.type.DateType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.websocket.OnMessage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "eventos")
public class EventoModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEvt;

    @NotEmpty @Size(min = 5, max = 150, message = "Digite um nome que tenha entre 5 e 150 caracteres") @Column(nullable = false)
    private String nomeEvt;

    @NotEmpty @Size(min = 10, max = 5000, message = "Digite uma descrição para o evento, que tenha entre 10 e 1000 caracteres") @Column(nullable = false)
    private String descEvt;

//    @NotEmpty @Column(nullable = false)
//    private String assuntoEvt;
//
//    @NotEmpty @Column(nullable = false)
//    private String categoriaEvt;

    @NotEmpty @Column(nullable = false)
    private String qtdPessEvt;

    @NotEmpty @Column(nullable = false)
    private String regiaoEvt;

    @NotEmpty @Size(min = 10, max = 250, message = "Digite o endereço do evento, que tenha entre 10 e 250 caracteres") @Column(nullable = false)
    private String localEvt;

    @NotEmpty @Column(nullable = false) @Size(min = 8, max = 8, message = "Digite apenas os números do cep")
    private String cepEvt;

    @NotEmpty @Size(min = 10, max = 250, message = "Digite o complemento do endereço do evento") @Column(nullable = false)
    private String complEvt;

    @Temporal(DATE)
    @DateTimeFormat (pattern="dd/MM/YYYY")
    @Column(nullable = false)
    private Date dataInicioEvt;

    @Temporal(DATE)
    @DateTimeFormat (pattern="dd/MM/YYYY")
    @Column(nullable = false)
    private Date dataFimEvt;

    @NotEmpty @Size(min = 5, max = 100, message = "Digite o nome da empresa / pessoa que está organizando o evento") @Column(nullable = false)
    private String orgEvt;

    @NotEmpty @Size(min = 5, max = 250, message = "Digite a desc. da empresa / pessoa que está organizando o evento") @Column(nullable = false)
    private String descOrgEvt;

    @Column(nullable = false)
    private String usrEvt;


    public EventoModel() {
        super();
    }

    public EventoModel( String nomeEvt, String descEvt, String qtdPessEvt, String regiaoEvt, String endrcEvt, String localEvt, String cepEvt, String complEvt, Date dataInicioEvt, Date dataFimEvt, String orgEvt, String descOrgEvt, String usrEvt) {
        super();
        this.nomeEvt = nomeEvt;
        this.descEvt = descEvt;
//        this.assuntoEvt = assuntoEvt;
//        this.categoriaEvt = categoriaEvt;
        this.qtdPessEvt = qtdPessEvt;
        this.regiaoEvt = regiaoEvt;
        this.localEvt = localEvt;
        this.cepEvt = cepEvt;
        this.complEvt = complEvt;
        this.dataInicioEvt = dataInicioEvt;
        this.dataFimEvt = dataFimEvt;
        this.orgEvt = orgEvt;
        this.descOrgEvt = descOrgEvt;
        this.usrEvt = usrEvt;
    }

    public int getIdEvt() { return idEvt; }
    public void setIdEvt(int idEvt) { this.idEvt = idEvt; }

    public String getNomeEvt() { return nomeEvt; }
    public void setNomeEvt(String nomeEvt) { this.nomeEvt = nomeEvt; }

    public String getDescEvt() { return descEvt; }
    public void setDescEvt(String descEvt) { this.descEvt = descEvt; }

    public String getQtdPessEvt() { return qtdPessEvt; }
    public void setQtdPessEvt(String qtdPessEvt) { this.qtdPessEvt = qtdPessEvt; }

    public String getRegiaoEvt() { return regiaoEvt; }
    public void setRegiaoEvt(String regiaoEvt) { this.regiaoEvt = regiaoEvt; }

    public String getLocalEvt() { return localEvt; }
    public void setLocalEvt(String localEvt) { this.localEvt = localEvt; }

    public String getCepEvt() { return cepEvt; }
    public void setCepEvt(String cepEvt) { this.cepEvt = cepEvt; }

    public String getComplEvt() { return complEvt; }
    public void setComplEvt(String complEvt) { this.complEvt = complEvt; }

    public Date getDataInicioEvt() { return dataInicioEvt; }
    public void setDataInicioEvt(Date dataInicioEvt) { this.dataInicioEvt = dataInicioEvt; }

    public Date getDataFimEvt() { return dataFimEvt; }
    public void setDataFimEvt(Date dataFimEvt) { this.dataFimEvt = dataFimEvt; }

    public String getOrgEvt() { return orgEvt; }
    public void setOrgEvt(String orgEvt) { this.orgEvt = orgEvt; }

    public String getDescOrgEvt() { return descOrgEvt; }
    public void setDescOrgEvt(String descOrgEvt) { this.descOrgEvt = descOrgEvt; }

    public String getUsrEvt() { return usrEvt; }
    public void setUsrEvt(String usrEvt) { this.usrEvt = usrEvt; }
}
