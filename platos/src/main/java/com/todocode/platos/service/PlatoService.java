package com.todocode.platos.service;

import com.todocode.platos.entity.Plato;
import com.todocode.platos.repository.IPlatoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoService implements IPlatoService{
   
   @Autowired
   IPlatoRepository platoRepository;

   @Override
   public List<Plato> getPlatos() {
      return platoRepository.findAll();
   }

   @Override
   public void savePlato(Plato p) {
      platoRepository.save(p); // con este método no podrá guardar la lista de ingredientes aún
   }

   @Override
   public Plato findPlato(Long id) {
      return platoRepository.findById(id).orElse(null);
   }

   @Override
   public void deletePlato(Long id) {
      platoRepository.deleteById(id);
   }

   @Override
   public void editPlato(Long id, Plato p) {
      
      Plato platoEdit = this.findPlato(p.getId());
      
      platoEdit.setNombre(p.getNombre());
      platoEdit.setPrecio(p.getPrecio());       
      platoEdit.setDescripcion(p.getDescripcion());
      platoEdit.setListaIngredientes(p.getListaIngredientes());
      
      platoRepository.save(platoEdit);
      
   }
   
}
