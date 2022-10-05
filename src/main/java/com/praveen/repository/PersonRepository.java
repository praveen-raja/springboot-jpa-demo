package com.praveen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.praveen.entity.Person;

@Repository
@Transactional
public class PersonRepository {
	
	// connect to database
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id)
	{
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	// TODO 
	// find_all_persons is not working
	public List<Person> findAll() {
		TypedQuery<Person> query = entityManager.createNamedQuery("find_all_persons", Person.class);
		
		return query.getResultList();
	}

}
