/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import upoanuncios.Usuario;

/**
 *
 * @author Alex
 */
public class usuariosDAO {

    public Usuario comprobarLogin(String correo, String password) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where correoElectronico='" + correo + "' and contrasenya='" + password + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }
}
