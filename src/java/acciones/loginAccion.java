package acciones;

import DAO.usuariosDAO;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import upoanuncios.Usuario;

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
 //         Comprobamos si el usuario se ha logueado correctamente. Si no es así se devolverá un null
         Usuario usuario = new usuariosDAO().comprobarLogin(this.getCorreoElectronico(), this.getContrasenya());
        if(usuario!=null){
            Map sesion = (Map) ActionContext.getContext().getSession();
            sesion.put("usuario", usuario); 
            if(usuario.getRol().getNombreRol().equals("Admin")){
//          Si el usuario tiene el rol de administrador creamos una variable en sesión llamada esAdmin
                sesion.put("esAdmin",true);
            }
            return SUCCESS;
        }else{
//            Si el objeto es de tipo null => logueo incorrecto
            Map sesion = (Map) ActionContext.getContext().getSession();
            sesion.put("logueoIncorrecto", true);
            return ERROR;
        }
    }
    
}
