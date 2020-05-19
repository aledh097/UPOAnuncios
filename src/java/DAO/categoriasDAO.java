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
import upoanuncios.Categoria;

/**
 *
 * @author Alex
 */
public class categoriasDAO {

    public List<Categoria> listadoCategorias() {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Categoria");
        List<Categoria> lc = (List<Categoria>) q.list();
        tx.commit();
        return lc;
    }

    public Categoria searchById(int id) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Categoria Where idCategoria=" + id);
        Categoria c = (Categoria) q.uniqueResult();
        tx.commit();
        return c;
    }

    public void altaCategoria(Categoria c) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(c);
        tx.commit();
    }

    public void borrar(int id) {
        Categoria c = new Categoria();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        c = (Categoria) session.createQuery("from Categoria where idCategoria='" + id + "'").uniqueResult();
        session.delete(c);
        tx.commit();
    }

    public void modCategoria(Categoria c) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(c);
        tx.commit();
    }
}
