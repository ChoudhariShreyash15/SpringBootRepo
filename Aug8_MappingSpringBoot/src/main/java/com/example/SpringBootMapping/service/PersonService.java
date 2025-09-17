package com.example.SpringBootMapping.service;

import com.example.SpringBootMapping.entity.Colony;
import com.example.SpringBootMapping.entity.Flat;
import com.example.SpringBootMapping.entity.Person;
import com.example.SpringBootMapping.repo.ColonyRepo;
import com.example.SpringBootMapping.repo.PersonRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {
    private PersonRepo personRepo;
    private ColonyRepo colonyRepo;

    public PersonService(PersonRepo personRepo, ColonyRepo colonyRepo) {
        this.personRepo = personRepo;
        this.colonyRepo = colonyRepo;
    }

    //POST or add
    public Person addPerson(Person person) {
//        log.info("person:{}",person);
        Colony colony = person.getColony();
//        log.info("colony:{}",person.getColony());
        if (colonyRepo.findByName(colony.getName()) == null) {
            colonyRepo.save(colony);
        }
        person.setColony(colony);
        List<Flat> flats = person.getFlats();
        if (flats != null) {
            for (Flat flat : flats) {
                flat.setPerson(person);
            }
        }
        return personRepo.save(person);
    }
}
