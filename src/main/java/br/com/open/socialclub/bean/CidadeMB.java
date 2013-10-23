/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.bean;

import br.com.open.socialclub.facade.SocialClubFacade;
import br.com.open.socialclub.modelo.Cidade;
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
public class CidadeMB implements Serializable {

    private SocialClubFacade socialClubFacade;
    private Cidade cidade = new Cidade();
    List<Cidade> cidades;
    
    /**
     * Creates a new instance of CidadeMB
     */
    public CidadeMB() {
        this.socialClubFacade = new SocialClubFacade();
    }
    
    public void salvarCidade(){
        try {
            socialClubFacade.salvarCidade(cidade);
        } catch (SocialClubException ex) {
            Logger.getLogger(CidadeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluirCidade(){
        try {
            socialClubFacade.exlcuirCidade(cidade);
        } catch (SocialClubException ex) {
            Logger.getLogger(CidadeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Cidade> getTodasCidades(){
        cidades = socialClubFacade.recuperarTodasCidades();
        return cidades;
    }
    
    public String retornarPaginaInicial(){
        cidade = new Cidade();
        
        return "/paginaInicial.xhtml?faces-redirect=true";
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
}
