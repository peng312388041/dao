package hello1;

import model.Person;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import util.DB;

public class TestImplPersonService {

	@Test
	public void test() {
		 SqlSessionFactory sessionFactory=DB.getSessionFactory();
		 SqlSession session=sessionFactory.openSession();
		 assert(null!=session);
		 Person person= session.selectOne("personMapper.selectPerson",11);
		 System.out.println(person);
	}
}
