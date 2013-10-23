package br.com.open.socialclub.modelo;

public class CNPJ {

    private String documento;

    public CNPJ() {
    }

    public CNPJ(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
