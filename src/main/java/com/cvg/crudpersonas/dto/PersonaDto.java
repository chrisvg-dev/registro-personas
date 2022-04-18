package com.cvg.crudpersonas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaDto {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
}
