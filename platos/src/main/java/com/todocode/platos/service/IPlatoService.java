package com.todocode.platos.service;

import com.todocode.platos.entity.Plato;
import java.util.List;


public interface IPlatoService {
   
   public List<Plato> getPlatos();
   
   public void savePlato(Plato p);
   
   public Plato findPlato(Long id);
   
   public void deletePlato(Long id);
   
   public void editPlato (Long id, Plato p);
}
