package upoanuncios;
// Generated 22-abr-2020 1:58:43 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Fotos generated by hbm2java
 */
public class Fotos  implements java.io.Serializable {


     private Integer idFotos;
     private String urlfoto1;
     private String urlfoto2;
     private String urlfoto3;
     private String urlfoto4;
     private String urlfoto5;
     private Set anuncios = new HashSet(0);

    public Fotos() {
    }

	
    public Fotos(String urlfoto1, String urlfoto2, String urlfoto3, String urlfoto4, String urlfoto5) {
        this.urlfoto1 = urlfoto1;
        this.urlfoto2 = urlfoto2;
        this.urlfoto3 = urlfoto3;
        this.urlfoto4 = urlfoto4;
        this.urlfoto5 = urlfoto5;
    }
    public Fotos(String urlfoto1, String urlfoto2, String urlfoto3, String urlfoto4, String urlfoto5, Set anuncios) {
       this.urlfoto1 = urlfoto1;
       this.urlfoto2 = urlfoto2;
       this.urlfoto3 = urlfoto3;
       this.urlfoto4 = urlfoto4;
       this.urlfoto5 = urlfoto5;
       this.anuncios = anuncios;
    }
   
    public Integer getIdFotos() {
        return this.idFotos;
    }
    
    public void setIdFotos(Integer idFotos) {
        this.idFotos = idFotos;
    }
    public String getUrlfoto1() {
        return this.urlfoto1;
    }
    
    public void setUrlfoto1(String urlfoto1) {
        this.urlfoto1 = urlfoto1;
    }
    public String getUrlfoto2() {
        return this.urlfoto2;
    }
    
    public void setUrlfoto2(String urlfoto2) {
        this.urlfoto2 = urlfoto2;
    }
    public String getUrlfoto3() {
        return this.urlfoto3;
    }
    
    public void setUrlfoto3(String urlfoto3) {
        this.urlfoto3 = urlfoto3;
    }
    public String getUrlfoto4() {
        return this.urlfoto4;
    }
    
    public void setUrlfoto4(String urlfoto4) {
        this.urlfoto4 = urlfoto4;
    }
    public String getUrlfoto5() {
        return this.urlfoto5;
    }
    
    public void setUrlfoto5(String urlfoto5) {
        this.urlfoto5 = urlfoto5;
    }
    public Set getAnuncios() {
        return this.anuncios;
    }
    
    public void setAnuncios(Set anuncios) {
        this.anuncios = anuncios;
    }




}


