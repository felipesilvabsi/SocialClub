package br.com.open.socialclub.modelo;

public class DadosPessoaJuridica {

    private String nomeFantasia;
    private CNPJ cnpj;
    private InscEstadual inscEstadual;
    private String inscMunicipal;
    private String crt;

    public DadosPessoaJuridica() {
        cnpj = new CNPJ();
        inscEstadual = new InscEstadual();
    }

    public DadosPessoaJuridica(String nomeFantasia, CNPJ cnpj,
            InscEstadual inscEstadual, String inscMunicipal, String crt) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.inscEstadual = inscEstadual;
        this.inscMunicipal = inscMunicipal;
        this.crt = crt;
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

    public InscEstadual getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(InscEstadual inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    public String getInscMunicipal() {
        return inscMunicipal;
    }

    public void setInscMunicipal(String inscMunicipal) {
        this.inscMunicipal = inscMunicipal;
    }

    public String getCrt() {
        return crt;
    }

    public void setCrt(String crt) {
        this.crt = crt;
    }
}
