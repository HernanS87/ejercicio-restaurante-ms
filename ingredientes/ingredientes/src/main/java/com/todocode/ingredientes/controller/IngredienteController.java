package com.todocode.ingredientes.controller;

import com.todocode.ingredientes.entity.Ingrediente;
import com.todocode.ingredientes.service.IIngredienteService;
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
@RequestMapping ("/ingrediente")
public class IngredienteController {
   
   @Autowired
   IIngredienteService ingredienteService;
   
   @GetMapping
   public String inicio(){
      return "Microservicio de Ingredienteeeees 🧂";
   }
   
   @GetMapping("/traer")
   public List<Ingrediente> traerIngredientes(){
      return ingredienteService.getIngredientes();
   }
   
   @GetMapping("/traer/{id}")
   public Ingrediente traerIngredienteById(@PathVariable Long id){
      return ingredienteService.findIngrediente(id);
   }
   
   @PostMapping("/crear")
   public String crearIngrediente(@RequestBody Ingrediente i){
      ingredienteService.saveIngrediente(i);
      return "Se creó el ingrediente " + i.getNombre() + " correctamente";
   }

   
   @DeleteMapping("/eliminar/{id}")
   public String eliminarIngrediente(@PathVariable Long id){
      ingredienteService.deleteIngrediente(id);
      return "Se eliminó el ingrediente correctamente";
   }
   
   @PutMapping("/editar")
   public String editarIngrediente(@RequestBody Ingrediente i){
      ingredienteService.editIngrediente(i.getId(), i);
      return "Se editó el ingrediente " + i.getNombre() + " correctamente";
   }
}
