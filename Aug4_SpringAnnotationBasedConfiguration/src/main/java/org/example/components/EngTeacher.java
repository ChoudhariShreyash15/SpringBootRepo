package org.example.components;

import org.example.repo.School;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EngTeacher implements School {
    public String name(){
        return "Priyanka";
    }
}
