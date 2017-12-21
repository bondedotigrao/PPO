package model.Implementacoes;

import model.interfaces.CorridaInterface;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.Corrida;
import model.Passageiro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Adrielly Sales
 */
public class CorridaHibernate  implements CorridaInterface{
    private EntityManager em;
    private SessionFactory sessions;
    private static CorridaHibernate instance =null;
    
    public static CorridaHibernate getInstance(){
        if(instance == null){
            instance = new CorridaHibernate();
        }
        return instance;
    }
    
    public CorridaHibernate(){
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
        
    }

    @Override
    public void cadastrar(Corrida corrida) {
        Session session = this.sessions.openSession();
       Transaction t = session.beginTransaction();
       
       try{
           session.persist(corrida);
           t.commit();
       }catch(Exception cadastroCorridaErro){
           System.out.println( cadastroCorridaErro.getCause()
                   + "\nAlgo de errado não está certo ao cadastrar corrida");
           t.rollback();
       }finally{
           session.close();
       } }

    @Override
    public void alterar(Corrida corrida) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.update(corrida);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        } }

    @Override
    public Corrida recuperar(int codigo) {
         Session session = this.sessions.openSession();
        
        try{
            return(Corrida) session.getSession().createQuery("from corrida where codigo=" + codigo).getResultList().get(0);
        }catch(Exception recuperaCorridaErro){
            System.out.println("Algo de errado não está certo ao recuperar corrida");
            
        }finally{
            session.close();
        }
        return null;
    }


    @Override
    public void deletar(Corrida corrida) {
        Session session = this.sessions.openSession();
       Transaction t = session.beginTransaction();
       
       try{
           session.delete(corrida);
           t.commit();
       }catch(Exception cadastroCorridaErro){
           System.out.println("Algo de errado não está certo ao deletar corrida");
           t.rollback();
       }finally{
           session.close();
       } }

    @Override
    public List<Corrida> recuperarTodos() {
    Session session = this.sessions.openSession();
      List<Corrida> lista = new ArrayList();      
      try{
          lista = session.createQuery("from corida").list();
      }catch(Exception listaTodasCorridasErro){
          System.out.println("Algo de errado não esta certo ao listar corrida");
      }finally{
          session.close();
      }
      
      return lista;
    }   
    }
    
