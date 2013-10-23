package br.com.open.socialclub.modelo;

public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String pontoReferencia;
    private String bairro;
    private Cidade cidade;
    private String cep;
    private String email;

    public Endereco() {
        cidade = new Cidade();
    }

    public Endereco(String logradouro, String numero, String complemento, String pontoReferencia,
            String bairro, Cidade cidade, String cep, String email) {
        super();
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.pontoReferencia = pontoReferencia;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
