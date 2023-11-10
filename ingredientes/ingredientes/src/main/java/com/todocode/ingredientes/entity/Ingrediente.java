package com.todocode.ingredientes.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Ingrediente {
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   // utilizamos esta notation para que nos cree una tabla intermedia con los nombres de todos los platos que tienen un mismo ingrediente
   @ElementCollection(fetch = FetchType.EAGER)
   private List<String> platos;
   
}
