package br.com.open.socialclub.modelo;

public class Cidade {

    private int codigo;
    private String nome;
    private String cep;
    private int codigoIBGE;
    private Estado estado;

    public Cidade() {
        estado = new Estado();
    }
    
    public Cidade(int codigo, String nome, String cep, int codigoIBGE, Estado estado) {
        this.codigo = codigo;
        this.nome = nome;
        this.cep = cep;
        this.codigoIBGE = codigoIBGE;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(int codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
