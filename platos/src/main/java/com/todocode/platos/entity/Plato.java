package com.todocode.platos.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Plato {
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   private Double precio;
   private String descripcion;
   
   @ElementCollection(fetch = FetchType.EAGER)
   private List<String> listaIngredientes;
   
}
