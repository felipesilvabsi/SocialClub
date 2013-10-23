/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.bean;

import br.com.open.socialclub.facade.SocialClubFacade;
import br.com.open.socialclub.modelo.Socio;
import br.com.open.socialclub.modelo.Telefone;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Felipe Silva
 */
@ManagedBean
@SessionScoped
public class SocioMB {

    SocialClubFacade socialClubFacade;
    Socio socio = new Socio();
    List<Socio> listaSocios = null;
    Telefone telefone = new Telefone();
    List<Telefone> telefones = null;

    /**
     * Creates a new instance of SocioMB
     */
    public SocioMB() {
        socialClubFacade = new SocialClubFacade();
    }

    public void salvar() {
    }

    public void adicionarTelefone() {
        try {
            if (telefones == null) {
                telefones = new ArrayList<Telefone>();
            }
            telefones.add(telefone);    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removerTelefone() {
        try {
            telefones.remove(telefone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public List<Socio> getListaSocios() {
        return listaSocios;
    }

    public void setListaSocios(List<Socio> listaSocios) {
        this.listaSocios = listaSocios;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
