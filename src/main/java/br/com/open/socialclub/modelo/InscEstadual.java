package br.com.open.socialclub.modelo;

public class InscEstadual {

    private String documento;
    private Estado estado;

    public InscEstadual() {
        estado = new Estado();
    }

    public InscEstadual(String documento, Estado estado) {
        this.documento = documento;
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
