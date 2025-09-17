package com.example.SpringBootMapping.repo;

import com.example.SpringBootMapping.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepo extends JpaRepository<Flat, Integer> {
}
