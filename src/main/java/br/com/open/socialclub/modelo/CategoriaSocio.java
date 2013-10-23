package br.com.open.socialclub.modelo;

public class CategoriaSocio {

    private int codigo;
    private String descricao;

    public CategoriaSocio() {
    }

    public CategoriaSocio(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
