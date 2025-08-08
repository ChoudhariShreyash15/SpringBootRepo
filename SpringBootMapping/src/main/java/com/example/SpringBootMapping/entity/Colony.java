package com.example.SpringBootMapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Colony {

    @Id
    @SequenceGenerator(name = "colony-seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "colony_seq")
    private int id;
    private String name;

    @OneToMany(mappedBy = "colony", cascade = CascadeType.ALL)
    private List<Person> persons;
}
