package br.com.open.socialclub.modelo;

/**
 *
 * @author Administrador
 */
public class Telefone {
    
    private String numero;
    private String contato;
    private TipoTelefone tipo;

    public Telefone() {
        
    }
    
    public Telefone(String numero, String contato, TipoTelefone tipo) {
        this.numero = numero;
        this.contato = contato;
        this.tipo = tipo;
    }
    
    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param documento the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @return the tipo
     */
    public TipoTelefone getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

}
