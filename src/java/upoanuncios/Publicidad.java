package upoanuncios;
// Generated 22-abr-2020 1:58:43 by Hibernate Tools 4.3.1



/**
 * Publicidad generated by hbm2java
 */
public class Publicidad  implements java.io.Serializable {


     private Integer idPublicidad;
     private Categoria categoria;
     private int titulo;
     private String descripcion;
     private String banner;

    public Publicidad() {
    }

    public Publicidad(Categoria categoria, int titulo, String descripcion, String banner) {
       this.categoria = categoria;
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.banner = banner;
    }
   
    public Integer getIdPublicidad() {
        return this.idPublicidad;
    }
    
    public void setIdPublicidad(Integer idPublicidad) {
        this.idPublicidad = idPublicidad;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public int getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(int titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getBanner() {
        return this.banner;
    }
    
    public void setBanner(String banner) {
        this.banner = banner;
    }




}


