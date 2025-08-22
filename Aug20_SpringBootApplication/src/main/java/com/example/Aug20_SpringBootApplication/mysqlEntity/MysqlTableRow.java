package com.example.Aug20_SpringBootApplication.mysqlEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "table_data_mysql")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MysqlTableRow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id cannot be null")
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 20, message = "Name must be 2-20 characters")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must not exceed 100")
    private Long age;

    @NotBlank(message = "Department cannot be blank")
    private String department;
}

