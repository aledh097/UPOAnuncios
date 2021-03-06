package upoanuncios;
// Generated 11-may-2020 4:09:43 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Categoria generated by hbm2java
 */
public class Categoria  implements java.io.Serializable {


     private Integer idCategoria;
     private String nombreCategoria;
     private Set anuncios = new HashSet(0);

    public Categoria() {
    }

	
    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    public Categoria(String nombreCategoria, Set anuncios) {
       this.nombreCategoria = nombreCategoria;
       this.anuncios = anuncios;
    }
   
    public Integer getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getNombreCategoria() {
        return this.nombreCategoria;
    }
    
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    public Set getAnuncios() {
        return this.anuncios;
    }
    
    public void setAnuncios(Set anuncios) {
        this.anuncios = anuncios;
    }




}


