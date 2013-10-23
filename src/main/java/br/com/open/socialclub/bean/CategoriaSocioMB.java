/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.bean;

import br.com.open.socialclub.facade.SocialClubFacade;
import br.com.open.socialclub.modelo.CategoriaSocio;
import br.com.open.socialclub.util.SocialClubException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CategoriaSocioMB implements Serializable {

    SocialClubFacade socialClubFacade;
    CategoriaSocio categoria = new CategoriaSocio();
    List<CategoriaSocio> categorias;
    
    /**
     * Creates a new instance of EstadoMB
     */
    public CategoriaSocioMB() {
        socialClubFacade = new SocialClubFacade();
    }
    
    public void salvarCategoriaSocio(){
        try {
            socialClubFacade.salvarCategoriaSocio(categoria);
            initObjetos();
        } catch (SocialClubException ex) {
            Logger.getLogger(CategoriaSocioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluirCategoriaSocio(){
        try {
            socialClubFacade.exlcuirCategoriaSocio(categoria);
            initObjetos();
        } catch (SocialClubException ex) {
            Logger.getLogger(CategoriaSocioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<CategoriaSocio> getTodasCategoriasSocio(){
        if (categorias == null) {
            categorias = socialClubFacade.recuperarTodasCategoriasSocio();
        }
        return categorias;
    }
    
    public void initObjetos(){
        categoria = new CategoriaSocio();
        categorias = null;
    }
    
    public String retornarPaginaInicial(){
        categoria = new CategoriaSocio();
        
        return "/paginaInicial.xhtml?faces-redirect=true";
    }
    
    public CategoriaSocio getCategoriaSocio() {
        return categoria;
    }

    public void setCategoriaSocio(CategoriaSocio categoria) {
        this.categoria = categoria;
    }
    
}
