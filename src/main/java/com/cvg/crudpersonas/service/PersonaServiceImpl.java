package com.cvg.crudpersonas.service;

import com.cvg.crudpersonas.model.Persona;
import com.cvg.crudpersonas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona nuevo(Persona persona) {
        if (persona.getId() != null) {
            Persona nuevo = this.personaRepository.getById( persona.getId() );
            if (nuevo != null) {
                return nuevo;
            }
        }
        return this.personaRepository.save(persona);
    }

    @Override
    public Persona editar(Persona persona) {
        Persona nuevo = this.personaRepository.getById( persona.getId() );
        if (nuevo == null) {
            return null;
        }
        return this.personaRepository.save(persona);
    }

    @Override
    public Persona consultarPersona(Integer id) {
        return this.personaRepository.getById(id);
    }

    @Override
    public List<Persona> listarPersonas() {
        return this.personaRepository.findAll();
    }

    @Override
    public Persona eliminarPersona(Integer id) {
        Persona eliminada = this.personaRepository.getById(id);
        if (eliminada != null) {
            this.personaRepository.delete(eliminada);
        }

        return null;
    }

    @Override
    public Persona buscarPorId(Integer id) {
        return this.personaRepository.getById(id);
    }
}
