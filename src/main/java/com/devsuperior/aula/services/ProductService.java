package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.CategoryInsertDTO;
import com.devsuperior.aula.dto.ProductInsertDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductInsertDTO insert(ProductInsertDTO prod){
        Product entity = new Product();
        entity.setId(prod.id());
        entity.setName(prod.name());
        entity.setPrice(prod.price());

        for(Category cat: prod.categories()){

            entity.getCategories().add(cat);
        }
        entity = productRepository.save(entity);
        return new ProductInsertDTO(entity);
    }
}
