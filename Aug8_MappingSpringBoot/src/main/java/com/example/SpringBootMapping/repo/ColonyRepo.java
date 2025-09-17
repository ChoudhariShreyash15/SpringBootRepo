package com.example.SpringBootMapping.repo;

import com.example.SpringBootMapping.entity.Colony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColonyRepo extends JpaRepository<Colony, Integer> {
    public Colony findByName(String name);
}
