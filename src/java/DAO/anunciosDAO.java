package DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import upoanuncios.Anuncio;

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

    public void altaAnuncio(Anuncio a) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(a);
        tx.commit();
    }
    
    public void modAnuncio(Anuncio a) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(a);
        tx.commit();
    }

    public void borrar(int id) {
        Anuncio a = new Anuncio();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        a = (Anuncio) session.createQuery("from Anuncio where idAnuncio='" + id + "'").uniqueResult();
        session.delete(a);
        tx.commit();
    }
    
     public Anuncio searchById(int id){
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncio Where idAnuncio="+id);
        Anuncio a = (Anuncio) q.uniqueResult();
        tx.commit();
        return a;
    }

}
