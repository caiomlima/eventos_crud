package com.eventos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eventos")
public class EventoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_evt;

    @Column(name="nome_evento", nullable = false, length = 200)
    private String nome_evt;

    @Column(name="desc_evento", nullable = false, length = 1000)
    private String desc_evt;

    // Colocar o seguinte comando na database evthj:
    // ALTER TABLE `eventos` CHANGE `data_evento` `data_evento` DATE;
    @Column(name="data_evento", nullable = false)
    private Date data_evt;

    @Column(name="qtd_pessoas_evento", nullable = false)
    private String qtd_pessoas_evt;

    @Column(name="regiao_evento", nullable = false)
    private String regiao_evt;

    @Column(name="endereco_evento", nullable = false, length = 250)
    private String endereco_evt;

    public EventoModel() {
        super();
    }

    public EventoModel(String nome_evt, String desc_evt, Date data_evt, String qtd_pessoas_evt, String regiao_evt, String endereco_evt) {
        super();
        this.nome_evt = nome_evt;
        this.desc_evt = desc_evt;
        this.data_evt = data_evt;
        this.qtd_pessoas_evt = qtd_pessoas_evt;
        this.regiao_evt = regiao_evt;
        this.endereco_evt = endereco_evt;
    }

    public int getId_evt() { return id_evt; }
    public void setId_evt(int id_evt) { this.id_evt = id_evt; }

    public String getNome_evt() { return nome_evt; }
    public void setNome_evt(String nome_evt) { this.nome_evt = nome_evt; }

    public String getDesc_evt() { return desc_evt; }
    public void setDesc_evt(String desc_evt) { this.desc_evt = desc_evt; }

    public Date getData_evt() { return data_evt; }
    public void setData_evt(Date data_evt) { this.data_evt = data_evt; }

    public String getQtd_pessoas_evt() { return qtd_pessoas_evt; }
    public void setQtd_pessoas_evt(String qtd_pessoas_evt) { this.qtd_pessoas_evt = qtd_pessoas_evt; }

    public String getRegiao_evt() { return regiao_evt; }
    public void setRegiao_evt(String regiao_evt) { this.regiao_evt = regiao_evt; }

    public String getEndereco_evt() { return endereco_evt; }
    public void setEndereco_evt(String endereco_evt) { this.endereco_evt = endereco_evt; }

}
