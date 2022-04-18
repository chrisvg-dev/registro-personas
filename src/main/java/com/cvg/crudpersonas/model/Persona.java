package com.cvg.crudpersonas.model;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "nombre", length = 50)
    private String nombre;
    @Column(nullable = false, name = "apellidos", length = 50)
    private String apellidos;
    private LocalDate fechaNacimiento;
}
