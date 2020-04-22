package upoanuncios;
// Generated 22-abr-2020 4:23:42 by Hibernate Tools 4.3.1



/**
 * Mensaje generated by hbm2java
 */
public class Mensaje  implements java.io.Serializable {


     private Integer idMensaje;
     private Anuncio anuncio;
     private Usuario usuarioByFkIdUsuarioDestino;
     private Usuario usuarioByFkIdUsuarioOrigen;

    public Mensaje() {
    }

    public Mensaje(Anuncio anuncio, Usuario usuarioByFkIdUsuarioDestino, Usuario usuarioByFkIdUsuarioOrigen) {
       this.anuncio = anuncio;
       this.usuarioByFkIdUsuarioDestino = usuarioByFkIdUsuarioDestino;
       this.usuarioByFkIdUsuarioOrigen = usuarioByFkIdUsuarioOrigen;
    }
   
    public Integer getIdMensaje() {
        return this.idMensaje;
    }
    
    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }
    public Anuncio getAnuncio() {
        return this.anuncio;
    }
    
    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
    public Usuario getUsuarioByFkIdUsuarioDestino() {
        return this.usuarioByFkIdUsuarioDestino;
    }
    
    public void setUsuarioByFkIdUsuarioDestino(Usuario usuarioByFkIdUsuarioDestino) {
        this.usuarioByFkIdUsuarioDestino = usuarioByFkIdUsuarioDestino;
    }
    public Usuario getUsuarioByFkIdUsuarioOrigen() {
        return this.usuarioByFkIdUsuarioOrigen;
    }
    
    public void setUsuarioByFkIdUsuarioOrigen(Usuario usuarioByFkIdUsuarioOrigen) {
        this.usuarioByFkIdUsuarioOrigen = usuarioByFkIdUsuarioOrigen;
    }




}

