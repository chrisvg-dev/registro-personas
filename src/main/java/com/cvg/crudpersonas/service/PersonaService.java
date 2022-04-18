package com.cvg.crudpersonas.service;

import com.cvg.crudpersonas.model.Persona;

import java.util.List;

public interface PersonaService {
    public Persona nuevo(Persona persona);
    public Persona editar(Persona persona);
    public Persona consultarPersona(Integer id);
    public List<Persona> listarPersonas();
    public Persona eliminarPersona(Integer id);
    public Persona buscarPorId(Integer id);
}
