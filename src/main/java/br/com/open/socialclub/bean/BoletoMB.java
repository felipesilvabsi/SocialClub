/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.bean;

import br.com.open.socialclub.util.GerarBoleto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.jrimum.bopepo.view.BoletoViewer;

/**
 *
 * @author Felipe Silva
 */
@ManagedBean
@RequestScoped
public class BoletoMB {

    GerarBoleto gerarBoleto = new GerarBoleto();

    /**
     * Creates a new instance of BoletoMB
     */
    public BoletoMB() {
    }

    public String download() {

        //BoletoViewer boletoViewer = new BoletoViewer(gerarBoleto.gerarBoleto());

        InputStream is = null;
        byte[] buffer = null;
        try {
            is = new FileInputStream(gerarBoleto.gerarCarneBoleto());
            buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        try {

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=boleto.pdf");

            OutputStream output = response.getOutputStream();
            output.write(buffer);
            response.flushBuffer();

            FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
