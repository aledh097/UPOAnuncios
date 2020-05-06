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
import upoanuncios.Anuncio;

/**
 *
 * @author Alex
 */
public class anunciosDAO {

    Session sesion = null;

    public List<Anuncio> listadoAnuncios() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncio");
        List<Anuncio> la = (List<Anuncio>) q.list();
        tx.commit();
        return la;
    }
}
