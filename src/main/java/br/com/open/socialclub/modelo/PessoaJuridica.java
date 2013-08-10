/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.modelo;

/**
 *
 * @author Felipe Silva
 */
public class PessoaJuridica {
    
    String CRT;
    String nomeFantasia;
    
    CNPJ cnpj;
    InscricaoEstadual inscricaoEstadual;

    public PessoaJuridica() {
    }
    
    public String getCRT() {
        return CRT;
    }

    public void setCRT(String CRT) {
        this.CRT = CRT;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public CNPJ getCnpj() {
        return cnpj;
    }

    public void setCnpj(CNPJ cnpj) {
        this.cnpj = cnpj;
    }

    public InscricaoEstadual getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(InscricaoEstadual inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
}
