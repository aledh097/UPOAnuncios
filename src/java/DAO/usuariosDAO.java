package DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import upoanuncios.Rol;
import upoanuncios.Usuario;

public class usuariosDAO {

    Session sesion = null;

    public Usuario comprobarLogin(String correo, String password) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where correoElectronico='" + correo + "' and contrasenya='" + password + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }

    public Rol rolCliente(){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Rol where nombreRol='Cliente'");
        Rol r = (Rol) q.uniqueResult();
        tx.commit();
        return r;
    }
    
    public void altaUsuario(Usuario u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
    }
}
