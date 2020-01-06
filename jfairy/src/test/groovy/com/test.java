package com;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import org.junit.Test;

public class test {

	@Test
	public void test(){
		Fairy fairy  =  Fairy.create();
		Person person  =  fairy.person();
		System.out.println(person.getFullName());
		System.out.println(person.getAddress().getAddressLine1());
	}


}
