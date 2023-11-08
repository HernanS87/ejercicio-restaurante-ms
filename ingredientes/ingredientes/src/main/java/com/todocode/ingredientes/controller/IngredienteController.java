package com.todocode.ingredientes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/ingrediente")
public class IngredienteController {
   
   @GetMapping
   public String inicio(){
      return "Microservicio de Ingredienteeeees 🧂";
   }
}
