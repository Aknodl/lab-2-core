package com.luxoft.springioc.lab2.model;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.springioc.lab2.model.Country;
import com.luxoft.springioc.lab2.model.UsualPerson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class SpringTCFAppTest {
	
	@Autowired
	private UsualPerson person;

	private UsualPerson expectedPerson;
	

	@Before
	public void setUp() throws Exception {
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
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