package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.HashSet;
import java.util.Set;

public record ProductInsertDTO(Long id, String name, Double price, Set<Category> categories) {
   public ProductInsertDTO(Product product){
       this(product.getId(), product.getName(), product.getPrice(), product.getCategories());
   }
}
