/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import DAO.anunciosDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import upoanuncios.Anuncio;

/**
 *
 * @author Alex
 */
public class listarAnunciosAccion extends ActionSupport {

    private List<Anuncio> anuncios = new ArrayList<>();
    private Integer idAnuncio;
    private String titulo;
    private String descripcion;
    private Float precio;
    private Date fechaCreacion;
    private int fkCodPostal;
    private int fkIdTipoAnuncio;
    private int fkIdCategoria;
    private int fkIdSubCategoria;
    private int fkIdFotos;
    private int fkIdUsuario;

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

    public int getFkCodPostal() {
        return fkCodPostal;
    }

    public void setFkCodPostal(int fkCodPostal) {
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

    public int getFkIdSubCategoria() {
        return fkIdSubCategoria;
    }

    public void setFkIdSubCategoria(int fkIdSubCategoria) {
        this.fkIdSubCategoria = fkIdSubCategoria;
    }

    public int getFkIdFotos() {
        return fkIdFotos;
    }

    public void setFkIdFotos(int fkIdFotos) {
        this.fkIdFotos = fkIdFotos;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }
   

    
    public listarAnunciosAccion() {
    }

    public String execute() throws Exception {
        try {
            anuncios = new anunciosDAO().listadoAnuncios();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

}
