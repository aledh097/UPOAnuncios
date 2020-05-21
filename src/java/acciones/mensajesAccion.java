/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import DAO.anunciosDAO;
import DAO.mensajesDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import upoanuncios.Anuncio;
import upoanuncios.Mensaje;
import upoanuncios.Usuario;

/**
 *
 * @author Alex
 */
public class mensajesAccion extends ActionSupport {

    private List<Mensaje> mensajes = new ArrayList<Mensaje>();
    private int idAnuncio;
    private String titulo;
    private String contenido;

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public mensajesAccion() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    

    public String execute() throws Exception {
        try {
            Map sesion = (Map) ActionContext.getContext().getSession();
            Usuario u = (Usuario) sesion.get("usuario");
            mensajes = new mensajesDAO().listadoAnuncios(u.getIdUsuario());
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }

    }

    public String almacenarIdAnuncio() {
        try {
            Map sesion = (Map) ActionContext.getContext().getSession();
            sesion.put("idAnuncio", getIdAnuncio());
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }

    }
    
    public String altaMensaje(){
        try {
            Map sesion = (Map) ActionContext.getContext().getSession();
            int idAnuncio = (int) sesion.get("idAnuncio");
            Anuncio a = new anunciosDAO().searchById(idAnuncio);
            Usuario u = (Usuario) sesion.get("usuario");
            Mensaje m = new Mensaje(a, a.getUsuario(), u, getTitulo(), getContenido());
            new mensajesDAO().altaMensaje(m);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

}
