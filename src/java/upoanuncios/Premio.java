package upoanuncios;
// Generated 22-abr-2020 18:24:58 by Hibernate Tools 4.3.1



/**
 * Premio generated by hbm2java
 */
public class Premio  implements java.io.Serializable {


     private Integer idPremio;
     private String titulo;
     private String descripcion;
     private String imagen;
     private int stock;

    public Premio() {
    }

    public Premio(String titulo, String descripcion, String imagen, int stock) {
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.imagen = imagen;
       this.stock = stock;
    }
   
    public Integer getIdPremio() {
        return this.idPremio;
    }
    
    public void setIdPremio(Integer idPremio) {
        this.idPremio = idPremio;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }




}


