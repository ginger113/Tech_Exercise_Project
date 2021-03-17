/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import datamodel.PlayerFuchs;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDBFuchs {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<PlayerFuchs> listPlayers() {
      List<PlayerFuchs> resultList = new ArrayList<PlayerFuchs>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

      try {
         tx = session.beginTransaction();
         List<?> players = session.createQuery("FROM PlayerFuchs").list();
         for (Iterator<?> iterator = players.iterator(); iterator.hasNext();) {
            PlayerFuchs playerFuchs = (PlayerFuchs) iterator.next();
            resultList.add(playerFuchs);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<PlayerFuchs> listPlayers(String keyword, String option) {
      List<PlayerFuchs> resultList = new ArrayList<PlayerFuchs>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> players = session.createQuery("FROM PlayerFuchs").list();
         for (Iterator<?> iterator = players.iterator(); iterator.hasNext();) {
            PlayerFuchs playerFuchs = (PlayerFuchs) iterator.next();
            if (option.startsWith("name")) {
	            if (playerFuchs.getName().contains(keyword)) {
	               resultList.add(playerFuchs);
	            }
	        } else {
	        	if (playerFuchs.getPos().contains(keyword)) {
		           resultList.add(playerFuchs);
		        }
	        }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static void createPlayers(String name, String team, String pos, String posRank, String avgPts, String totPts) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new PlayerFuchs(name, team, pos, posRank, avgPts, totPts));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
