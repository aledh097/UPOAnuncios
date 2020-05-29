package acciones;

import DAO.categoriasDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import upoanuncios.Categoria;

public class categoriasAccion extends ActionSupport {

    private List<Categoria> categorias = new ArrayList();
    private Integer idCategoria;
    private String nombreCategoria;

    public categoriasAccion() {
    }

    public categoriasAccion(Integer idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    @StringLengthFieldValidator(minLength = "4", maxLength = "20", message = "La categoría debe tener al menos 4 caracteres y menos de 20 caracteres")
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String execute() throws Exception {
        try {
            categorias = new categoriasDAO().listadoCategorias();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String altaCategoria() {
        try {
//            Damos de alta una categoría
            String nombre = getNombreCategoria();
            Categoria c = new Categoria(nombre);
            new categoriasDAO().altaCategoria(c);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String borrarCategoria() {
        try {
//            Borramos una categoría con el identificador del mismo
            new categoriasDAO().borrar(getIdCategoria());
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String datosCategoriaMod() {
        try {
//            Guardamos la categoría en sesión
            Map session = (Map) ActionContext.getContext().get("session");
            Categoria c = new categoriasDAO().searchById(getIdCategoria());
            session.put("categoria", c);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String modCategoria() {
        try {
            Map session = (Map) ActionContext.getContext().get("session");
            Categoria c = (Categoria) session.get("categoria");
            c.setNombreCategoria(getNombreCategoria());
            new categoriasDAO().modCategoria(c);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

}
