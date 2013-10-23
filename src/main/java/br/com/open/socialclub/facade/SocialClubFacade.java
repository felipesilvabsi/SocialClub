/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.facade;

import br.com.open.socialclub.dao.CategoriaSocioDAO;
import br.com.open.socialclub.dao.CidadeDAO;
import br.com.open.socialclub.dao.EstadoDAO;
import br.com.open.socialclub.dao.PaisDAO;
import br.com.open.socialclub.dao.TipoSocioDAO;
import br.com.open.socialclub.dao.TipoTelefoneDAO;
import br.com.open.socialclub.modelo.CategoriaSocio;
import br.com.open.socialclub.modelo.Cidade;
import br.com.open.socialclub.modelo.Estado;
import br.com.open.socialclub.modelo.Pais;
import br.com.open.socialclub.modelo.TipoSocio;
import br.com.open.socialclub.modelo.TipoTelefone;
import br.com.open.socialclub.persistencia.DaoException;
import br.com.open.socialclub.util.SocialClubException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe Silva
 */
public class SocialClubFacade {
    private CategoriaSocioDAO categoriaSocioDAO;
    private CidadeDAO cidadeDAO;
    private EstadoDAO estadoDAO;
    private PaisDAO paisDAO;
    private TipoSocioDAO tipoSocioDAO;
    private TipoTelefoneDAO tipoTelefoneDAO;

    public SocialClubFacade() {
        this.categoriaSocioDAO = new CategoriaSocioDAO(true);
        this.cidadeDAO = new CidadeDAO(true);
        this.estadoDAO = new EstadoDAO(true);
        this.paisDAO = new PaisDAO(true);
        this.tipoSocioDAO = new TipoSocioDAO(true);
        this.tipoTelefoneDAO = new TipoTelefoneDAO(true);
    }
    
    public void salvarCategoriaSocio(CategoriaSocio categoriaSocio) throws SocialClubException{
        try {
            if (categoriaSocio.getCodigo() != 0) {
                categoriaSocioDAO.update(categoriaSocio);
            } else {
                categoriaSocioDAO.save(categoriaSocio);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SocialClubException(e.getMessage());
        }
    }
    
    public void exlcuirCategoriaSocio(CategoriaSocio categoriaSocio) throws SocialClubException{
        try {
            categoriaSocioDAO.delete(categoriaSocio);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SocialClubException(e.getMessage());
        }
    }
    
    public List<CategoriaSocio> recuperarTodasCategoriasSocio(){
        try {
            return categoriaSocioDAO.findAll();
        } catch (DaoException ex) {
            Logger.getLogger(SocialClubFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public void salvarCidade(Cidade cidade) throws SocialClubException{
        try {
            if (cidade.getCodigo() != 0) {
                cidadeDAO.update(cidade);
            } else {
                cidadeDAO.save(cidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SocialClubException(e.getMessage());
        }
    }
    
    public void exlcuirCidade(Cidade cidade) throws SocialClubException{
        try {
            cidadeDAO.delete(cidade);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SocialClubException(e.getMessage());
        }
    }
    
    public List<Cidade> recuperarTodasCidades(){
        try {
            return cidadeDAO.findAll();
        } catch (DaoException ex) {
            Logger.getLogger(SocialClubFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Estado> recuperarTodosEstados(){
        try {
            return estadoDAO.findAll();
        } catch (DaoException ex) {
            Logger.getLogger(SocialClubFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Pais> recuperarTodosPaises(){
        try {
            return paisDAO.findAll();
        } catch (DaoException ex) {
            Logger.getLogger(SocialClubFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void salvarTipoSocio(TipoSocio tipoSocio) throws SocialClubException{
        try {
            if (tipoSocio.getCodigo() != 0) {
                tipoSocioDAO.update(tipoSocio);
            } else {
                tipoSocioDAO.save(tipoSocio);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SocialClubException(e.getMessage());
        }
    }
    
    public void exlcuirTipoSocio(TipoSocio tipoSocio) throws SocialClubException{
        try {
            tipoSocioDAO.delete(tipoSocio);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SocialClubException(e.getMessage());
        }
    }
    
    public List<TipoSocio> recuperarTodosTiposSocio(){
        try {
            return tipoSocioDAO.findAll();
        } catch (DaoException ex) {
            Logger.getLogger(SocialClubFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public void salvarTipoTelefone(TipoTelefone tipoTelefone) throws SocialClubException{
        try {
            if (tipoTelefone.getCodigo() != 0) {
                tipoTelefoneDAO.update(tipoTelefone);
            } else {
                tipoTelefoneDAO.save(tipoTelefone);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SocialClubException(e.getMessage());
        }
    }
    
    public void exlcuirTipoTelefone(TipoTelefone tipoTelefone) throws SocialClubException{
        try {
            tipoTelefoneDAO.delete(tipoTelefone);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SocialClubException(e.getMessage());
        }
    }
    
    public List<TipoTelefone> recuperarTodosTiposTelefone(){
        try {
            return tipoTelefoneDAO.findAll();
        } catch (DaoException ex) {
            Logger.getLogger(SocialClubFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
}
