package util;

import implservice.ImplPersonService;
import iservice.IPersonService;

import org.apache.log4j.PropertyConfigurator;

public class Main {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties ");
		// Logger logger = Logger.getLogger(ImplPersonDao.class);
		// logger.debug(null);
		IPersonService service = new ImplPersonService();

		// System.out.println(service.getCount());

		// System.out.println(service.getAll());

		// System.out.println(service.get(12));

		// Person person = service.get(12);
		// person.setPerson_name("ちくしょう");
		// service.update(person);

		// Person person = new Person();
		// person.setPerson_name("chong");
		// person.setPerson_age(15);
		// service.insert(person);

		System.out.println(service.delete(26));
	}
}
