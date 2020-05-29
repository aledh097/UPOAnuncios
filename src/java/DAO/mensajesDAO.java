package DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import upoanuncios.Mensaje;

public class mensajesDAO {

    public List<Mensaje> listadoMensajes(int id) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Mensaje Where FK_idUsuarioDestino=" + id);
        List<Mensaje> lm = (List<Mensaje>) q.list();
        tx.commit();
        return lm;
    }

    public void altaMensaje(Mensaje m) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(m);
        tx.commit();
    }

}
