package com.todocode.ingredientes.service;

import com.todocode.ingredientes.entity.Ingrediente;
import java.util.List;


public interface IIngredienteService {
   
   public List<Ingrediente> getIngredientes();
   
   public void saveIngrediente(Ingrediente i);
   
   public Ingrediente findIngrediente(Long id);
   
   public void deleteIngrediente(Long id);
   
   public void editIngrediente(Long id, Ingrediente i);
   
}
