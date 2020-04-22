package upoanuncios;
// Generated 22-abr-2020 4:23:42 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private Rol rol;
     private String nombre;
     private String apellidos;
     private String telefono;
     private String correoElectronico;
     private String contrasenya;
     private Date fechaAlta;

    public Usuario() {
    }

	
    public Usuario(Rol rol, String nombre, String apellidos, String telefono, String correoElectronico, String contrasenya, Date fechaAlta) {
        this.rol = rol;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.contrasenya = contrasenya;
        this.fechaAlta = fechaAlta;
    }
    public Usuario(Rol rol, String nombre, String apellidos, String telefono, String correoElectronico, String contrasenya, Date fechaAlta, Set mensajesForFkIdUsuarioDestino, Set mensajesForFkIdUsuarioOrigen, Set anuncios) {
       this.rol = rol;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.telefono = telefono;
       this.correoElectronico = correoElectronico;
       this.contrasenya = contrasenya;
       this.fechaAlta = fechaAlta;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getContrasenya() {
        return this.contrasenya;
    }
    
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

}