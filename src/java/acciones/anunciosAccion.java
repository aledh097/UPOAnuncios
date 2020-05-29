package acciones;

import DAO.anunciosDAO;
import DAO.categoriasDAO;
import DAO.municipiosDAO;
import DAO.tiposanuncioDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import upoanuncios.Anuncio;
import upoanuncios.Categoria;
import upoanuncios.Municipio;
import upoanuncios.Tipoanuncio;
import upoanuncios.Usuario;

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

    @StringLengthFieldValidator(minLength = "4", maxLength = "50", message = "El título debe tener al menos 4 caracteres y menos de 50 caracteres")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @StringLengthFieldValidator(minLength = "4", maxLength = "200", message = "La descripción debe tener al menos 4 caracteres y menos de 200 caracteres")
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    @RegexFieldValidator(regex = "\\d+", message = "El precio tiene que ser un número")
    @DoubleRangeFieldValidator(minExclusive = "0.0", message = "El precio debe ser mayor de 0 €")
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
//            Obtenemos la información de las entidades relacionada al anuncio a modificar
            Map session = (Map) ActionContext.getContext().get("session");
            Usuario u = (Usuario) session.get("usuario");
            Categoria c = new categoriasDAO().searchById(getFkIdCategoria());
            Tipoanuncio t = new tiposanuncioDAO().searchById(getFkIdTipoAnuncio());
            Municipio m = new municipiosDAO().searchByCodPostal(getFkCodPostal());
            Date date = new Date();
//            Creamos el objeto anuncio
            Anuncio anuncio = new Anuncio(c, m, t, u, getTitulo(), getDescripcion(), getPrecio(), date);
            int identificador;
            identificador = getIdAnuncio();
            anuncio.setIdAnuncio(identificador);
//            Procedemos a la modificación de los datos del anuncio
            new anunciosDAO().modAnuncio(anuncio);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String altaAnuncio() {
        try {
//            Obtenemos el usuario de la sesión y rellenamos los datos del anuncio
            Map session = (Map) ActionContext.getContext().get("session");
            Usuario u = (Usuario) session.get("usuario");
            Categoria c = new categoriasDAO().searchById(getFkIdCategoria());
            Tipoanuncio t = new tiposanuncioDAO().searchById(getFkIdTipoAnuncio());
            Municipio m = new municipiosDAO().searchByCodPostal(getFkCodPostal());
            Date date = new Date();
            Anuncio anuncio = new Anuncio(c, m, t, u, getTitulo(), getDescripcion(), getPrecio(), date);
//             Damos de alta el anuncio
            new anunciosDAO().altaAnuncio(anuncio);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String borrarAnuncio() {
        try {
            //Borramos el anuncio según el identificador del mismo
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
            session.put("anuncio", a);

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

}
