/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.bean;

import br.com.open.socialclub.facade.SocialClubFacade;
import br.com.open.socialclub.modelo.TipoSocio;
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
public class TipoSocioMB implements Serializable {

    private SocialClubFacade socialClubFacade;
    private TipoSocio tipo = new TipoSocio();
    List<TipoSocio> tiposSocio;
    
    /**
     * Creates a new instance of CidadeMB
     */
    public TipoSocioMB() {
        this.socialClubFacade = new SocialClubFacade();
    }
    
    public void salvarTipoSocio(){
        try {
            socialClubFacade.salvarTipoSocio(tipo);
        } catch (SocialClubException ex) {
            Logger.getLogger(TipoSocioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluirTipoSocio(){
        try {
            socialClubFacade.exlcuirTipoSocio(tipo);
        } catch (SocialClubException ex) {
            Logger.getLogger(TipoSocioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<TipoSocio> getTodosTiposSocio(){
        tiposSocio = socialClubFacade.recuperarTodosTiposSocio();
        return tiposSocio;
    }
    
    public String retornarPaginaInicial(){
        tipo = new TipoSocio();
        
        return "/paginaInicial.xhtml?faces-redirect=true";
    }
    
    public TipoSocio getTipoSocio() {
        return tipo;
    }

    public void setTipoSocio(TipoSocio tipo) {
        this.tipo = tipo;
    }
    
}
