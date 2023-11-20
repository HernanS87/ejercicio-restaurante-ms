package com.todocode.platos.service;

import com.todocode.platos.dto.IngredienteDTO;
import com.todocode.platos.entity.Plato;
import com.todocode.platos.repository.IPlatoRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlatoService implements IPlatoService{
   
   @Autowired
   IPlatoRepository platoRepository;
   @Autowired
   RestTemplate consumirAPI;
   
   //Esta es otra forma de implementar RestTemplate sin necesidad de crear la clase AppConfig
   //RestTemplate api = new RestTemplate();

   @Override
   public List<Plato> getPlatos() {
      return platoRepository.findAll();
   }

   @Override
   public void savePlato(Plato p) {
      
      List<String> listIngByPlato = new ArrayList<>();
      String url = "http://localhost:9010/ingrediente/traer/" + p.getNombre() ;
      
      List<IngredienteDTO> ingredientes = Arrays.asList(consumirAPI.getForObject(url, IngredienteDTO[].class));
      
      for(IngredienteDTO i : ingredientes){
         listIngByPlato.add(i.getNombre());
      }
      
      p.setListaIngredientes(listIngByPlato);
      platoRepository.save(p); 
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
