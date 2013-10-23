package br.com.open.socialclub.modelo;

public class Pais {

    private int codigo;
    private String sigla;
    private String nome;

    public Pais() {
    }

    public Pais(int codigo, String sigla, String nome) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
