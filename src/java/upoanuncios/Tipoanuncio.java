package upoanuncios;
// Generated 22-abr-2020 4:23:42 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tipoanuncio generated by hbm2java
 */
public class Tipoanuncio  implements java.io.Serializable {


     private Integer idTipoAnuncio;
     private String nombre;
     private Set anuncios = new HashSet(0);

    public Tipoanuncio() {
    }

	
    public Tipoanuncio(String nombre) {
        this.nombre = nombre;
    }
    public Tipoanuncio(String nombre, Set anuncios) {
       this.nombre = nombre;
       this.anuncios = anuncios;
    }
   
    public Integer getIdTipoAnuncio() {
        return this.idTipoAnuncio;
    }
    
    public void setIdTipoAnuncio(Integer idTipoAnuncio) {
        this.idTipoAnuncio = idTipoAnuncio;
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


