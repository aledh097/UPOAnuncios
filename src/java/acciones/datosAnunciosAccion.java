/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import DAO.anunciosDAO;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import upoanuncios.Anuncio;

/**
 *
 * @author Alex
 */
public class datosAnunciosAccion extends ActionSupport {
    
    private List<Anuncio> anuncios = new ArrayList<>();
    
    public datosAnunciosAccion() {
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }
    
    
    
    public String execute() throws Exception {
        try {
            anuncios = new anunciosDAO().listadoAnuncios();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
    
}
