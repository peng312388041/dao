package implDao.hibernate;

import iDao.IPersonDao;

import java.util.List;

import model.Person;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import util.DB;

public class ImplPersonDao implements IPersonDao {

	private Session session = null;
	private Transaction tx = null;

	public int insert(Person person) {
		System.out
				.println("-------------------hibernate----------------------");
		try {
			session = DB.getHibernateSession();
			tx = session.beginTransaction();
			session.save(person);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			return 0;
		}
		return 1;
	}

	public Person delete(int id) {
		System.out
				.println("-------------------hibernate----------------------");
		Person person = null;
		if (get(id) == null) {
			return null;
		}
		try {
			person = get(id);
			session = DB.getHibernateSession();
			tx = session.beginTransaction();
			session.delete(person);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return person;
	}

	public int update(Person person) {
		System.out
				.println("-------------------hibernate----------------------");
		try {
			session = DB.getHibernateSession();
			tx = session.beginTransaction();
			session.update(person);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			return 0;
		}
		return 1;
	}

	public Person get(int id) {
		System.out
				.println("-------------------hibernate----------------------");
		Person person = null;
		try {
			session = DB.getHibernateSession();
			tx = session.beginTransaction();
			Object o = session.get(Person.class, id);
			if (null == o) {
				return null;
			}
			person = (Person) o;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return person;
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAll() {
		System.out
				.println("-------------------hibernate----------------------");
		List<Person> personList = null;
		try {
			session = DB.getHibernateSession();
			tx = session.beginTransaction();
			personList = session.createSQLQuery("select * from Person").list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return personList;
	}

	public long getCount() {
		System.out
				.println("-------------------hibernate----------------------");
		long count = 0;
		try {
			session = DB.getHibernateSession();
			tx = session.beginTransaction();
			count = (Long) session.createCriteria(Person.class)
					.setProjection(Projections.rowCount()).uniqueResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return count;
	}
}
