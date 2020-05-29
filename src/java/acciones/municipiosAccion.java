package acciones;

import DAO.municipiosDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import upoanuncios.Municipio;

public class municipiosAccion extends ActionSupport {

    private String codPostal;
    private String nombreMunicipio;
    private List<Municipio> municipios = new ArrayList();

    public String getCodPostal() {
        return codPostal;
    }

//    Número entre 01000 y 52999
    @RegexFieldValidator(regex = "0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}", message = "Código postal incorrecto")
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    @StringLengthFieldValidator(minLength = "2", maxLength = "100", message = "El municipio debe tener al menos 2 caracteres y menos de 100 caracteres")
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
//            Listamos todos los municipios
            municipios = new municipiosDAO().listadoMunicipios();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String datosMunicipioMod() {
        try {
//            Guardamos el municipio en sesión
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
//            Modificamos el municipio
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
//            Damos de alta un municipio
            Municipio m = new Municipio(getCodPostal(), getNombreMunicipio());
            new municipiosDAO().altaMunicipio(m);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
    
    public String borrarMunicipio() {
        try {
//            Borramos un municipio
            new municipiosDAO().borrar(getCodPostal());
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
}



