package acciones;

import DAO.anunciosDAO;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import upoanuncios.Anuncio;

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
            //Obtenemos el listado de todos los anuncios
            anuncios = new anunciosDAO().listadoAnuncios();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

}
