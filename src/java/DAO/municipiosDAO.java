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
import upoanuncios.Municipio;

/**
 *
 * @author Alex
 */
public class municipiosDAO {

    public List<Municipio> listadoMunicipios() {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Municipio");
        List<Municipio> lm = (List<Municipio>) q.list();
        tx.commit();
        return lm;
    }

    public Municipio searchByCodPostal(String codPostal) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Municipio Where codPostal =" + codPostal + "");
        Municipio s = (Municipio) q.uniqueResult();
        tx.commit();
        return s;
    }

    public void modMunicipio(Municipio m) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(m);
        tx.commit();
    }

    public void borrar(String codPostal) {
        Municipio m = new Municipio();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        m = (Municipio) session.createQuery("from Municipio where codPostal='" + codPostal + "'").uniqueResult();
        session.delete(m);
        tx.commit();
    }

    public void altaMunicipio(Municipio m) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(m);
        tx.commit();
    }
}
