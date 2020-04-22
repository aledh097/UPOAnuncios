/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import DAO.usuariosDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import upoanuncios.Rol;
import upoanuncios.Usuario;

/**
 *
 * @author Alex
 */
public class registroAccion extends ActionSupport {

    private Integer idUsuario;
    private Rol rol;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correoElectronico;
    private String contrasenya;
    private Date fechaAlta;

    public registroAccion() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String execute() throws Exception {
        try {
            Rol r = new usuariosDAO().rolCliente();
            Usuario u = new Usuario(r, getNombre(), getApellidos(), getTelefono(), getCorreoElectronico(), getContrasenya(), null);
            new usuariosDAO().altaUsuario(u);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }

    }

}
