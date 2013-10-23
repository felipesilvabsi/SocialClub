package br.com.open.socialclub.modelo;

public class Estado {

    private int codigo;
    private String sigla;
    private String nome;
    private String regiao;
    private Double populacao;
    private Pais pais;

    public Estado() {
        pais = new Pais();
    }

    public Estado(int codigo, String sigla, String nome, String regiao, Double populacao, Pais pais) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.nome = nome;
        this.regiao = regiao;
        this.populacao = populacao;
        this.pais = pais;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the regiao
     */
    public String getRegiao() {
        return regiao;
    }

    /**
     * @param regiao the regiao to set
     */
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    /**
     * @return the populacao
     */
    public Double getPopulacao() {
        return populacao;
    }

    /**
     * @param populacao the populacao to set
     */
    public void setPopulacao(Double populacao) {
        this.populacao = populacao;
    }

    /**
     * @return the pais
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
