package com.flint.elasticsearch;

import com.flint.elasticsearch.data.es.entity.Person;
import com.flint.elasticsearch.data.es.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticsearchApplicationTests {
	@Autowired
	private PersonRepository personRepository;
	@Test
	public void contextLoads() {
		Person p = new Person();
		p.setId(1L);
		p.setName("ligeng");
		personRepository.save(p);

		Person one = personRepository.findOne(1L);
		System.out.println(one);
	}

}
