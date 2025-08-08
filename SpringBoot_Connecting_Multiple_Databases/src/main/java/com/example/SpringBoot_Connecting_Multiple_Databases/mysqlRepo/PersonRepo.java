package com.example.SpringBoot_Connecting_Multiple_Databases.mysqlRepo;

import com.example.SpringBoot_Connecting_Multiple_Databases.mysqlEntity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
