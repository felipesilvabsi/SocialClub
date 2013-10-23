/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.bean;

import br.com.open.socialclub.facade.SocialClubFacade;
import br.com.open.socialclub.modelo.Estado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Felipe Silva
 */
@ManagedBean
@RequestScoped
public class EstadoMB implements Serializable {

    SocialClubFacade socialClubFacade;
    Estado estado;
    List<Estado> estados;
    
    /**
     * Creates a new instance of EstadoMB
     */
    public EstadoMB() {
        socialClubFacade = new SocialClubFacade();
        estados = new ArrayList<Estado>();
    }
    
    public List<Estado> getTodosEstados(){
        estados = socialClubFacade.recuperarTodosEstados();
        return estados;
    }
    
}
