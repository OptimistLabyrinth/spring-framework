package com.ksyoo.spring_master_class_fourth.jpa;

import com.ksyoo.spring_master_class_fourth.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll() {
        var namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(Long id) {
        var person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }
}
