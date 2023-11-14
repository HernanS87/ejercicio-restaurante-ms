package com.todocode.platos.controller;

import com.todocode.platos.entity.Plato;
import com.todocode.platos.service.IPlatoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platos")
public class PlatoController {
   
   @Autowired
   IPlatoService platoService;
   
   
   @GetMapping ("/traer")
   public List<Plato> traerPlatos(){
      return platoService.getPlatos();
   }
   
   @GetMapping ("/traer/{id}")
   public Plato findPlato(@PathVariable Long id){
      return platoService.findPlato(id);
   }
   
   @PostMapping("/crear")
   public String crearPlato(@RequestBody Plato p){
      platoService.savePlato(p);
      return "Se creó el plato " + p.getNombre() + " correctamente";
   }
   
   @DeleteMapping("/eliminar/{id}")
   public String eliminarPlato(@PathVariable Long id){
      platoService.deletePlato(id);
      return "Se eliminó el plato correctamente";
   }
   
   @PutMapping("/editar/{id}")
   public String editarPlato(@PathVariable Long id,
                             @RequestBody Plato p){
      platoService.editPlato(id, p);
      return "Se editó el plato " + p.getNombre() + " correctamente";
   }
}
