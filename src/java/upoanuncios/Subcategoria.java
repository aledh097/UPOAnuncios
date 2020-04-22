package upoanuncios;
// Generated 22-abr-2020 4:23:42 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Subcategoria generated by hbm2java
 */
public class Subcategoria  implements java.io.Serializable {


     private Integer idSubCateogoria;
     private Categoria categoria;
     private String nombre;
     private Set anuncios = new HashSet(0);

    public Subcategoria() {
    }

	
    public Subcategoria(Categoria categoria, String nombre) {
        this.categoria = categoria;
        this.nombre = nombre;
    }
    public Subcategoria(Categoria categoria, String nombre, Set anuncios) {
       this.categoria = categoria;
       this.nombre = nombre;
       this.anuncios = anuncios;
    }
   
    public Integer getIdSubCateogoria() {
        return this.idSubCateogoria;
    }
    
    public void setIdSubCateogoria(Integer idSubCateogoria) {
        this.idSubCateogoria = idSubCateogoria;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getAnuncios() {
        return this.anuncios;
    }
    
    public void setAnuncios(Set anuncios) {
        this.anuncios = anuncios;
    }




}


