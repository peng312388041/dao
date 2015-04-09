package implservice;

import iDao.IPersonDao;
import iservice.IPersonService;

import java.util.List;

import model.Person;

public class ImplPersonService implements IPersonService {

	// private IPersonDao dao = new implDao.hibernate.ImplPersonDao();

	// private IPersonDao dao = new implDao.mybatis.ImplPersonDao();

	private IPersonDao dao = new implDao.jdbc.ImplPersonDao();

	public int insert(Person person) {
		return dao.insert(person);
	}

	public Person delete(int id) {
		return dao.delete(id);
	}

	public int update(Person person) {
		return dao.update(person);
	}

	public Person get(int id) {
		return dao.get(id);
	}

	public List<Person> getAll() {
		return dao.getAll();
	}

	public long getCount() {
		return dao.getCount();
	}

}
