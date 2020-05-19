/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import DAO.categoriasDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import upoanuncios.Categoria;

/**
 *
 * @author Alejandro
 */
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
            new categoriasDAO().borrar(getIdCategoria());
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String datosCategoriaMod() {
        try {
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
