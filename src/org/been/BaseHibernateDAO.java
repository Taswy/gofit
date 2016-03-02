package org.been;

import java.io.Serializable;
import java.util.List;

import org.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	/**
	 *  ��hibernateSession������ȡ��session���Ӷ���
	 */
	public Session getSession() {
		 return HibernateSessionFactory.getSession();
	}

	/**
	 * �ر�session����
	 */
	public void closeSession() {
		HibernateSessionFactory.closeSession();

	}

	/**
	 * ��������
	 * @param po  Object ��ű����ݵĶ�����Ҫ��������ָ�������ҵ����
	 * @throws HibernateException  ��������ʱ�������쳣
	 * @return Object ���ز���ɹ����ҵ�����
	 */
	public Object insert(Object po) {
		Session session = getSession();
		try {		
			Transaction tran = session.beginTransaction();
			session.save(po);
			//session.flush();
			tran.commit();
			return po;
		} catch (HibernateException ex) {
			throw ex;
		}finally{
			session.close();
		}
	}

	/**
	 * ��������
	 */
	public void renew(Object po) {
		Session session = getSession();
		try {
			Transaction tran = session.beginTransaction();
			session.update(po); // ��¼������ʱ,updateҲ�������
			tran.commit();
		} catch (HibernateException ex) {
			throw ex;
		}
		try {
			//session.flush();
			session.close();
		} catch (HibernateException ex1) {
			throw ex1;
		}
	}

	/**
	 * ɾ��һ�����ݣ�ע�⣬������ɾ��ʱ������ӿ�Ч�ʽϵͣ���Ϊ���Ȳ�ѯһ����¼����ɾ��һ����¼,
	 * @param businessClass Class ҵ������class
	 * @param id  String ����
	 */
	public void delete(Class businessClass, java.io.Serializable id) {
		Session session = getSession();
		Object obj = null;
		Transaction tran = session.beginTransaction();
		try {
			obj = session.get(businessClass, id);
		} catch (HibernateException ex) {
			throw ex;
		}
		if (obj != null) {
			try {
				session.delete(obj);
				tran.commit();
			} catch (HibernateException ex1) {
				throw ex1;
			}
		}
		try {
			//session.flush();
			session.close();
		} catch (HibernateException ex2) {
			throw ex2;
		}
	}

	public void delete(Object obj) {
		Session session = getSession();
		try {
			Transaction tran = session.beginTransaction();
			session.delete(obj);
			//session.flush();
			tran.commit();
			session.close();
		} catch (HibernateException ex2) {
			throw ex2;
		}finally{
			this.closeSession();
		}
	}

	/**
	 * ��ѯһ���¼
	 * @param hsql String HSQL���
	 * @return List һ��������
	 * @throws Exception
	 */
	public List search(String hsql) {
		System.out.println(hsql);
		Session session = getSession();
		List alist = null;
		try {
			alist = session.createQuery(hsql).list();
			session.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return alist;
	}

	/**
	 * ��ѯһ���ض��ļ�¼
	 * @param businessClass  Class ҵ������class
	 * @param id  SerialObject ����,���л�����
	 * @return Object ҵ�����
	 */
	public Object search(Class businessClass, java.io.Serializable id) {
		Session session = getSession();
		try {
			return session.load(businessClass, id); // ��¼������ʱ,���׳�ObjectNotFoundException
		} catch (HibernateException ex) {
			ex.printStackTrace();
			throw ex;
		}finally{
			this.closeSession();
		}
	}

	/*
	 * ��������
	 */
	public void saveObject(Object o) {
		Session session = this.getSession();
		Transaction tran = session.beginTransaction();
		session.saveOrUpdate(o);
		tran.commit();
		this.closeSession();
	}

	/**
	 * ��id��
	 */
	public Object getObject(Class clazz, Serializable id) {
		Session session = this.getSession();
		Object o = session.get(clazz, id);
		this.closeSession();
		return o;
	}

	/**
	 * �����е�
	 */
	public List getObjects(Class clazz) {
		Session session = this.getSession();
		List alist = session.createQuery("from " + clazz.getName()).list();
		this.closeSession();
		return alist;
	}
	
}