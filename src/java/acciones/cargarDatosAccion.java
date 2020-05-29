package acciones;

import DAO.anunciosDAO;
import DAO.categoriasDAO;
import DAO.municipiosDAO;
import DAO.tiposanuncioDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import upoanuncios.Categoria;
import upoanuncios.Municipio;
import upoanuncios.Tipoanuncio;

public class cargarDatosAccion extends ActionSupport {

    private List<Categoria> categorias;
    private List<Tipoanuncio> tiposanuncio;
    private List<Municipio> municipios;

    public cargarDatosAccion() {
    }

    public String datosAnuncio() {
        try {

            //Cargamos en sesión todos los datos relacionados con el anuncio
            
            Map session = (Map) ActionContext.getContext().get("session");

            categorias = new categoriasDAO().listadoCategorias();
            tiposanuncio = new tiposanuncioDAO().listadoTiposAnuncio();
            municipios = new municipiosDAO().listadoMunicipios();

            session.put("categorias", categorias);
            session.put("tiposanuncio", tiposanuncio);
            session.put("municipios", municipios);

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
