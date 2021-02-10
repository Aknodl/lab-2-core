package com.luxoft.springioc.lab2.model;
import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luxoft.springioc.lab2.model.Country;
import com.luxoft.springioc.lab2.model.UsualPerson;

import java.util.List;
import java.util.ArrayList;

public class SimpleAppTest {
	
	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

	private AbstractApplicationContext context;

	private UsualPerson expectedPerson;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
				APPLICATION_CONTEXT_XML_FILE_NAME);
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		UsualPerson person = (UsualPerson) context.getBean("person");
//		FYI: Another way to achieve the bean
//		person = context.getBean(UsualPerson.class);
		assertEquals(expectedPerson, person);
		System.out.println(person);
	}

	private UsualPerson getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(35);
		person.setHeight(1.78F);
		person.setIsProgrammer(true);
		person.setName("Ivan Ivanov");

		Country country = new Country();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");

		person.setCountry(country);


		List<Contact> contacts = new ArrayList<>();
		Contact mike= new Contact();
		mike.setName("Mike");
		mike.setPhoneNumber("+7-234-456-67-89");
		mike.setEmail("asd@asd.ru");
		Contact jack= new Contact();
		jack.setName("Jack");
		jack.setPhoneNumber("+7-234-456-67-90");
		jack.setEmail("jack@lag.ru");
		contacts.add(mike);
		contacts.add(jack);
		person.setContacts(contacts);

		return person;
	}
}
