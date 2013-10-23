package br.com.open.socialclub.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio {

    private int codigo;
    private String nome;
    private Endereco endereco;
    private DadosPessoaFisica dadosPessoaFisica;
    private DadosPessoaJuridica dadosPessoaJuridica;
    private CategoriaSocio categoriaSocio;
    private TipoSocio tipoSocio;
    private boolean inativo;
    private Date dataCadastro;
    private String cadastradoPor;
    private Date dataModificado;
    private String modificadoPor;

    private ArrayList<Telefone> telefones;

    public Socio() {
        endereco = new Endereco();
        dadosPessoaFisica = new DadosPessoaFisica();
        dadosPessoaJuridica = new DadosPessoaJuridica();
        categoriaSocio = new CategoriaSocio();
        tipoSocio = new TipoSocio();
        telefones = new ArrayList<Telefone>();
    }

    /**
     *
     * @param codigo
     * @param tipo
     * @param nome
     * @param endereco
     * @param dadosPessoaFisica
     * @param dadosPessoaJuridica
     * @param categoriaSocio
     * @param tipoSocio
     * @param inativo
     * @param dataCadastro
     * @param cadastradoPor
     * @param dataModificado
     * @param modificadoPor
     * @param telefones
     */
    public Socio(int codigo, String nome, Endereco endereco, DadosPessoaFisica dadosPessoaFisica,
            DadosPessoaJuridica dadosPessoaJuridica, CategoriaSocio categoriaSocio,
            TipoSocio tipoSocio, boolean inativo, Date dataCadastro, String cadastradoPor,
            Date dataModificado, String modificadoPor, ArrayList<Telefone> telefones) {
        
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.dadosPessoaFisica = dadosPessoaFisica;
        this.dadosPessoaJuridica = dadosPessoaJuridica;
        this.categoriaSocio = categoriaSocio;
        this.tipoSocio = tipoSocio;
        this.inativo = inativo;
        this.dataCadastro = dataCadastro;
        this.cadastradoPor = cadastradoPor;
        this.dataModificado = dataModificado;
        this.modificadoPor = modificadoPor;
        this.telefones = telefones;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public DadosPessoaFisica getDadosPessoaFisica() {
        return dadosPessoaFisica;
    }

    public void setDadosPessoaFisica(DadosPessoaFisica dadosPessoaFisica) {
        this.dadosPessoaFisica = dadosPessoaFisica;
    }

    public DadosPessoaJuridica getDadosPessoaJuridica() {
        return dadosPessoaJuridica;
    }

    public void setDadosPessoaJuridica(DadosPessoaJuridica dadosPessoaJuridica) {
        this.dadosPessoaJuridica = dadosPessoaJuridica;
    }

    public CategoriaSocio getCategoriaSocio() {
        return categoriaSocio;
    }

    public void setCategoriaSocio(CategoriaSocio categoriaSocio) {
        this.categoriaSocio = categoriaSocio;
    }

    public TipoSocio getTipoSocio() {
        return tipoSocio;
    }

    public void setTipoSocio(TipoSocio tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCadastradoPor() {
        return cadastradoPor;
    }

    public void setCadastradoPor(String cadastradoPor) {
        this.cadastradoPor = cadastradoPor;
    }

    public Date getDataModificado() {
        return dataModificado;
    }

    public void setDataModificado(Date dataModificado) {
        this.dataModificado = dataModificado;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }
}
