package br.com.coretecnologia.pagamento;
// Generated 06/10/2019 11:39:00 by Hibernate Tools 5.2.12.Final

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Home object for domain model class Pagamento.
 * @see br.com.coretecnologia.pagamento.Pagamento
 * @author Hibernate Tools
 */
public class PagamentoDAO {

	private static final Log log = LogFactory.getLog(PagamentoDAO.class);
	
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().
				configure(new File("src/META-INF/hibernate.cfg.xml"))
				.buildSessionFactory();
		return sessionFactory; 
	}

	public void persist(Pagamento transientInstance) {
		log.debug("persisting Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.persist(transientInstance);
			session.getTransaction().commit();
			
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	
	public void delete(Pagamento persistentInstance) {
		log.debug("deleting Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void merge(Pagamento detachedInstance) {
		log.debug("merging Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.merge(detachedInstance);
			session.getTransaction().commit();
			
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public List<Pagamento> findAll() {
		log.debug("merging Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			//HQL
			String hql = "from Pagamento";
			Query query = session.createQuery(hql);
			List<Pagamento> pagamentos = query.list();
			session.getTransaction().commit();
			
			return pagamentos;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public Pagamento find(PagamentoId pgtoId) {
		log.debug("merging Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Pagamento instance = (Pagamento) sessionFactory.getCurrentSession().get("br.com.coretecnologia.pagamento.Pagamento", pgtoId);
			session.getTransaction().commit();
			
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
}
