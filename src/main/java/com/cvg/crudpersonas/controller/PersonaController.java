package com.cvg.crudpersonas.controller;

import com.cvg.crudpersonas.dto.PersonaDto;
import com.cvg.crudpersonas.model.Persona;
import com.cvg.crudpersonas.service.PersonaService;
import com.cvg.crudpersonas.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public String listar(Model modelo){
        modelo.addAttribute("personas", this.personaService.listarPersonas());
        return "index";
    }

    @GetMapping("/personas/nuevo")
    public String nuevaPersona(Model modelo) {
        PersonaDto persona = new PersonaDto();
        modelo.addAttribute("persona", persona);
        return "nueva-persona";
    }

    @PostMapping("/guardar")
    public String guardarPersona(@ModelAttribute("persona") PersonaDto persona) {
        Persona nuevoRegistro = new Persona();
        nuevoRegistro.setNombre(persona.getNombre());
        nuevoRegistro.setApellidos(persona.getApellidos());
        LocalDate fechaNac = LocalDate.parse(persona.getFechaNacimiento());
        nuevoRegistro.setFechaNacimiento(fechaNac);
        personaService.nuevo(nuevoRegistro);
        return "redirect:/";
    }

    @GetMapping("/personas/editar/{id}")
    public String showEditForm(@PathVariable Integer id, Model modelo) {
        Persona p = this.personaService.buscarPorId(id);
        PersonaDto obj = PersonaDto.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .apellidos(p.getApellidos())
                .fechaNacimiento(p.getFechaNacimiento().toString())
                .build();
        modelo.addAttribute("persona", obj);
        return "editar-persona";
    }

    @PostMapping("/editar")
    public String editarPersona(@ModelAttribute("persona") PersonaDto persona) {
        Persona nuevoRegistro = new Persona();
        nuevoRegistro.setId(persona.getId());
        nuevoRegistro.setNombre(persona.getNombre());
        nuevoRegistro.setApellidos(persona.getApellidos());
        LocalDate fechaNac = LocalDate.parse(persona.getFechaNacimiento());
        nuevoRegistro.setFechaNacimiento(fechaNac);
        personaService.editar(nuevoRegistro);
        return "redirect:/";
    }

    @GetMapping("/personas/eliminar/{id}")
    public String eliminarPersona(@PathVariable Integer id) {
        Persona p = this.personaService.buscarPorId(id);
        if (p != null) {
            this.personaService.eliminarPersona(id);
        }
        return "redirect:/";
    }
}
