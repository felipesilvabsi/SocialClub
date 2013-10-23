package br.com.open.socialclub.modelo;

import java.util.Date;

public class RG {

    private String numero;
    private String orgaoEmissor;
    private Estado uf;
    private Date dataEmissao;

    public RG() {
    }

    public RG(String numero, String orgaoEmissor, Estado uf, Date dataEmissao) {
        this.numero = numero;
        this.orgaoEmissor = orgaoEmissor;
        this.uf = uf;
        this.dataEmissao = dataEmissao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public Estado getUf() {
        return uf;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
