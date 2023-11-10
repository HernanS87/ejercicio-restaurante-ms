package com.todocode.ingredientes.service;

import com.todocode.ingredientes.entity.Ingrediente;
import com.todocode.ingredientes.repository.IIngredienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService implements IIngredienteService{
   
   @Autowired
   IIngredienteRepository ingredienteRepository;

   @Override
   public List<Ingrediente> getIngredientes() {
      return ingredienteRepository.findAll();
   }

   @Override
   public void saveIngrediente(Ingrediente i) {
      ingredienteRepository.save(i);
   }
   
   @Override
   public Ingrediente findIngrediente(Long id){
      return ingredienteRepository.findById(id).orElse(null);
   }

   @Override
   public void deleteIngrediente(Long id) {
      ingredienteRepository.deleteById(id);
   }

   @Override
   public void editIngrediente(Long id, Ingrediente i) {
      
      Ingrediente ingrediente = this.findIngrediente(id);
      
      ingrediente.setNombre(i.getNombre());
      ingrediente.setPlatos(i.getPlatos());
      
      ingredienteRepository.save(ingrediente);
   }

   @Override
   public List<Ingrediente> getIngredientesByPlato(String plato) {
      return ingredienteRepository.findByPlato(plato);
   }
   
}
