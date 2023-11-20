package com.todocode.platos.dto;

import java.util.List;
import lombok.Data;

@Data
public class IngredienteDTO {
   
   private Long id;
   private String nombre;
   private List<String> platos;
   
}
