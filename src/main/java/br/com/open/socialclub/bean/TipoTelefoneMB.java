/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.bean;

import br.com.open.socialclub.facade.SocialClubFacade;
import br.com.open.socialclub.modelo.TipoTelefone;
import br.com.open.socialclub.util.SocialClubException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Felipe Silva
 */
@ManagedBean
@RequestScoped
public class TipoTelefoneMB implements Serializable {

    private SocialClubFacade socialClubFacade;
    private TipoTelefone tipo = new TipoTelefone();
    List<TipoTelefone> tiposTelefone;
    
    /**
     * Creates a new instance of CidadeMB
     */
    public TipoTelefoneMB() {
        this.socialClubFacade = new SocialClubFacade();
    }
    
    public void salvarTipoTelefone(){
        try {
            socialClubFacade.salvarTipoTelefone(tipo);
        } catch (SocialClubException ex) {
            Logger.getLogger(TipoTelefoneMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluirTipoTelefone(){
        try {
            socialClubFacade.exlcuirTipoTelefone(tipo);
        } catch (SocialClubException ex) {
            Logger.getLogger(TipoTelefoneMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<TipoTelefone> getTodosTiposTelefone(){
        tiposTelefone = socialClubFacade.recuperarTodosTiposTelefone();
        return tiposTelefone;
    }
    
    public String retornarPaginaInicial(){
        tipo = new TipoTelefone();
        
        return "/paginaInicial.xhtml?faces-redirect=true";
    }
    
    public TipoTelefone getTipoTelefone() {
        return tipo;
    }

    public void setTipoTelefone(TipoTelefone tipo) {
        this.tipo = tipo;
    }
    
}
