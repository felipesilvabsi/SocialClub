/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.bean;

import br.com.open.socialclub.facade.SocialClubFacade;
import br.com.open.socialclub.modelo.Pais;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PaisMB implements Serializable {

    SocialClubFacade socialClubFacade;
    Pais pais;
    List<Pais> paises;
    
    /**
     * Creates a new instance of EstadoMB
     */
    public PaisMB() {
        socialClubFacade = new SocialClubFacade();
        paises = new ArrayList<Pais>();
    }
    
    public List<Pais> getTodosPaises(){
        paises = socialClubFacade.recuperarTodosPaises();
        return paises;
    }
    
}
