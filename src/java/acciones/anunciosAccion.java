/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import DAO.anunciosDAO;
import DAO.categoriasDAO;
import DAO.municipiosDAO;
import DAO.tiposanuncioDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import upoanuncios.Anuncio;
import upoanuncios.Categoria;
import upoanuncios.Municipio;
import upoanuncios.Tipoanuncio;
import upoanuncios.Usuario;

/**
 *
 * @author Alex
 */
public class anunciosAccion extends ActionSupport {

    private List<Anuncio> anuncios = new ArrayList<>();
    private Integer idAnuncio;
    private String titulo;
    private String descripcion;
    private Float precio;
    private Date fechaCreacion;

    private String fkCodPostal;
    private int fkIdTipoAnuncio;
    private int fkIdCategoria;

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFkCodPostal() {
        return fkCodPostal;
    }

    public void setFkCodPostal(String fkCodPostal) {
        this.fkCodPostal = fkCodPostal;
    }

    public int getFkIdTipoAnuncio() {
        return fkIdTipoAnuncio;
    }

    public void setFkIdTipoAnuncio(int fkIdTipoAnuncio) {
        this.fkIdTipoAnuncio = fkIdTipoAnuncio;
    }

    public int getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(int fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
    }

    public anunciosAccion() {
    }
    

    public String modAnuncio() {
        try {
            Map session = (Map) ActionContext.getContext().get("session");
            Usuario u = (Usuario) session.get("usuario");
            Categoria c = new categoriasDAO().searchById(getFkIdCategoria());
            Tipoanuncio t = new tiposanuncioDAO().searchById(getFkIdTipoAnuncio());
            Municipio m = new municipiosDAO().searchByCodPostal(getFkCodPostal());
            Date date = new Date();
            Anuncio anuncio = new Anuncio(c, m, t, u, getTitulo(), getDescripcion(), getPrecio(), date);
            int identificador;
            identificador = getIdAnuncio();
            anuncio.setIdAnuncio(identificador);
            new anunciosDAO().modAnuncio(anuncio);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String altaAnuncio() {
        try {
            Map session = (Map) ActionContext.getContext().get("session");
            Usuario u = (Usuario) session.get("usuario");
            Categoria c = new categoriasDAO().searchById(getFkIdCategoria());
            Tipoanuncio t = new tiposanuncioDAO().searchById(getFkIdTipoAnuncio());
            Municipio m = new municipiosDAO().searchByCodPostal(getFkCodPostal());
            Date date = new Date();
            Anuncio anuncio = new Anuncio(c, m, t, u, getTitulo(), getDescripcion(), getPrecio(), date);
            new anunciosDAO().altaAnuncio(anuncio);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String borrarAnuncio() {
        try {
            new anunciosDAO().borrar(getIdAnuncio());
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    private List<Categoria> categorias;
    private List<Tipoanuncio> tiposanuncio;
    private List<Municipio> municipios;

    public String datosAnuncioMod() {
        try {

            Map session = (Map) ActionContext.getContext().get("session");

            categorias = new categoriasDAO().listadoCategorias();
            tiposanuncio = new tiposanuncioDAO().listadoTiposAnuncio();
            municipios = new municipiosDAO().listadoMunicipios();

            session.put("categorias", categorias);
            session.put("tiposanuncio", tiposanuncio);
            session.put("municipios", municipios);

            Anuncio a = new anunciosDAO().searchById(getIdAnuncio());
            session.put("anuncio",a);

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

}
