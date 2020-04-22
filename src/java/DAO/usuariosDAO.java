/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import upoanuncios.Rol;
import upoanuncios.Usuario;

/**
 *
 * @author Alex
 */
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
        Query q = sesion.createQuery("From Rol where nombre='Cliente'");
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
