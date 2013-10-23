package br.com.open.socialclub.modelo;

import java.util.Date;

public class DadosPessoaFisica {

    private CPF cpf;
    private RG rg;
    private String apelido;
    private String nomeDoPai;
    private String nomeDaMae;
    private Date dataNascimento;
    private String sexo;

    public DadosPessoaFisica() {
        cpf = new CPF();
        rg = new RG();
    }

    public DadosPessoaFisica(CPF cpf, RG rg, String apelido,
            String nomeDoPai, String nomeDaMae, Date dataNascimento, String sexo) {
        this.cpf = cpf;
        this.rg = rg;
        this.apelido = apelido;
        this.nomeDoPai = nomeDoPai;
        this.nomeDaMae = nomeDaMae;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public RG getRg() {
        return rg;
    }

    public void setRg(RG rg) {
        this.rg = rg;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
