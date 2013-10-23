package br.com.open.socialclub.modelo;

import java.util.Date;

public class Parcela {

    private int numero;
    private String numeroDoc;
    private Conta tipoCobranca;
    private Date vencimento;
    private double valor;
    private Date baixa;
    private String baixadoPor;
    private double valorPago;
    private Date dataPagto;
    private String pagoPor;

    public Parcela() {
        super();
        tipoCobranca = new Conta();
    }

    public Parcela(int numero, String numeroDoc, Conta tipoCobranca,
            Date vencimento, double valor, Date baixa, String baixadoPor,
            double valorPago, Date dataPagto, String pagoPor) {
        super();
        this.numero = numero;
        this.numeroDoc = numeroDoc;
        this.tipoCobranca = tipoCobranca;
        this.vencimento = vencimento;
        this.valor = valor;
        this.baixa = baixa;
        this.baixadoPor = baixadoPor;
        this.valorPago = valorPago;
        this.dataPagto = dataPagto;
        this.pagoPor = pagoPor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public Conta getTipoCobranca() {
        return tipoCobranca;
    }

    public void setTipoCobranca(Conta tipoCobranca) {
        this.tipoCobranca = tipoCobranca;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getBaixa() {
        return baixa;
    }

    public void setBaixa(Date baixa) {
        this.baixa = baixa;
    }

    public String getBaixadoPor() {
        return baixadoPor;
    }

    public void setBaixadoPor(String baixadoPor) {
        this.baixadoPor = baixadoPor;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(Date dataPagto) {
        this.dataPagto = dataPagto;
    }

    public String getPagoPor() {
        return pagoPor;
    }

    public void setPagoPor(String pagoPor) {
        this.pagoPor = pagoPor;
    }
}
