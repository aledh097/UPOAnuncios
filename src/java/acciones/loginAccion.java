/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import DAO.usuariosDAO;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import upoanuncios.Usuario;

/**
 *
 * @author Alex
 */
public class loginAccion extends ActionSupport {
    
     private String correoElectronico;
     private String contrasenya;

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
     
     
    
    public loginAccion() {
    }
    
    public String execute() throws Exception {     
         Usuario usuario = new usuariosDAO().comprobarLogin(this.getCorreoElectronico(), this.getContrasenya());
        if(usuario!=null){
            Map sesion = (Map) ActionContext.getContext().getSession();
            sesion.put("usuario", usuario);                     
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
    
}
