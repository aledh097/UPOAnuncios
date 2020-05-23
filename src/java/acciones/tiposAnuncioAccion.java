/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import DAO.categoriasDAO;
import DAO.tiposanuncioDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import upoanuncios.Categoria;
import upoanuncios.Tipoanuncio;

/**
 *
 * @author Alejandro
 */
public class tiposAnuncioAccion extends ActionSupport {

    private List<Tipoanuncio> tiposanuncio = new ArrayList();
    private Integer idTipoAnuncio;
    private String nombreTipoAnuncio;

    public tiposAnuncioAccion() {
    }

    public tiposAnuncioAccion(Integer idTipoAnuncio, String nombreTipoAnuncio) {
        this.idTipoAnuncio = idTipoAnuncio;
        this.nombreTipoAnuncio = nombreTipoAnuncio;
    }

    public List<Tipoanuncio> getTiposanuncio() {
        return tiposanuncio;
    }

    public void setTiposanuncio(List<Tipoanuncio> tiposanuncio) {
        this.tiposanuncio = tiposanuncio;
    }

    public Integer getIdTipoAnuncio() {
        return idTipoAnuncio;
    }

    public void setIdTipoAnuncio(Integer idTipoAnuncio) {
        this.idTipoAnuncio = idTipoAnuncio;
    }

    public String getNombreTipoAnuncio() {
        return nombreTipoAnuncio;
    }

    @StringLengthFieldValidator(minLength = "4", maxLength = "20", message = "El tipo de anuncio debe tener al menos 4 caracteres y menos de 20 caracteres")
    public void setNombreTipoAnuncio(String nombreTipoAnuncio) {
        this.nombreTipoAnuncio = nombreTipoAnuncio;
    }

    public String execute() throws Exception {
        try {
            tiposanuncio = new tiposanuncioDAO().listadoTiposAnuncio();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String altaTipoAnuncio() {
        try {
            String nombre = getNombreTipoAnuncio();
            Tipoanuncio t = new Tipoanuncio(nombre);
            new tiposanuncioDAO().altaTipoAnuncio(t);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String borrarTipoAnuncio() {
        try {
            new tiposanuncioDAO().borrar(getIdTipoAnuncio());
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String datosTipoAnuncioMod() {
        try {
            Map session = (Map) ActionContext.getContext().get("session");
            Tipoanuncio t = new tiposanuncioDAO().searchById(getIdTipoAnuncio());
            session.put("tipoanuncio", t);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String modTipoAnuncio() {
        try {
            Map session = (Map) ActionContext.getContext().get("session");
            Tipoanuncio t = (Tipoanuncio) session.get("tipoanuncio");
            t.setNombreTipoAnuncio(getNombreTipoAnuncio());
            new tiposanuncioDAO().modTipoAnuncio(t);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

}
