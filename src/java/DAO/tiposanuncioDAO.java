/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import upoanuncios.Tipoanuncio;

/**
 *
 * @author Alex
 */
public class tiposanuncioDAO {
    public List<Tipoanuncio> listadoTiposAnuncio() {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Tipoanuncio");
        List<Tipoanuncio> lt = (List<Tipoanuncio>) q.list();
        tx.commit();
        return lt;
    }
    
            public Tipoanuncio searchById(int id){
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Tipoanuncio Where idTipoAnuncio="+id+"");
        Tipoanuncio s = (Tipoanuncio) q.uniqueResult();
        tx.commit();
        return s;
    }
}
