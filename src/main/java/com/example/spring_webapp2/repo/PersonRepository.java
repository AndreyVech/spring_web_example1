package com.example.spring_webapp2.repo;

import com.example.spring_webapp2.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
//    @Query("update person set name=?, email=? where id = ?")
//    @Modifying
//    Person updatePerson(Person person);
}
