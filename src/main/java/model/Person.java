package model;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer person_id;
	private String person_name;
	private Integer person_age;
	public Integer getPerson_id() {
		return person_id;
	}
	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public Integer getPerson_age() {
		return person_age;
	}
	public void setPerson_age(Integer person_age) {
		this.person_age = person_age;
	}
	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", person_name="
				+ person_name + ", person_age=" + person_age + "]";
	}
	
}
