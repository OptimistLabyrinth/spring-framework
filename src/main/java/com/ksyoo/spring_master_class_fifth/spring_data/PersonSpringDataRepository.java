package com.ksyoo.spring_master_class_fifth.spring_data;

import com.ksyoo.spring_master_class_fifth.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Long> {
}
