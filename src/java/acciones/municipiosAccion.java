/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import DAO.municipiosDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import upoanuncios.Municipio;

/**
 *
 * @author Alex
 */
public class municipiosAccion extends ActionSupport {

    private String codPostal;
    private String nombreMunicipio;
    private List<Municipio> municipios = new ArrayList();

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }


    public municipiosAccion() {
    }

    public String execute() throws Exception {
        try {
            municipios = new municipiosDAO().listadoMunicipios();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String datosMunicipioMod() {
        try {
            Map session = (Map) ActionContext.getContext().get("session");
            Municipio m = new municipiosDAO().searchByCodPostal(getCodPostal());
            session.put("municipio", m);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String modMunicipio() {
        try {
            Map session = (Map) ActionContext.getContext().get("session");
            Municipio m = (Municipio) session.get("municipio");
            m.setNombreMunicipio(getNombreMunicipio());
            new municipiosDAO().modMunicipio(m);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String altaMunicipio() {
        try {
            Municipio m = new Municipio(getCodPostal(), getNombreMunicipio());
            new municipiosDAO().altaMunicipio(m);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
    
    public String borrarMunicipio() {
        try {
            new municipiosDAO().borrar(getCodPostal());
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
}



